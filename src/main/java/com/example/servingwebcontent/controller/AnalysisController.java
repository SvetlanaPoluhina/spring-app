package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.*;
import com.example.servingwebcontent.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class AnalysisController {
    @Autowired
    private UserRepo usersRepo;
    @Autowired
    private AnalysisRepo analysisRepo;
    @Autowired
    private PlaceRepo placeRepo;

    @PreAuthorize("hasAuthority('DOCTOR')")
    @GetMapping("/analysis")
    public String analysis( Map<String, Object> model){
        Iterable<Analysis> analysises = analysisRepo.findAll();

        Iterable<User> users = usersRepo.findAll();
        Iterable<Place> places = placeRepo.findAll();

        model.put("analysises", analysises);
        model.put("users", users);
        model.put("places", places);

        return "analysis";
    }

    @PreAuthorize("hasAuthority('DOCTOR')")
    @PostMapping("/analysis")
    public String add(
            @RequestParam User user,
            @RequestParam String name_analysis,
            @AuthenticationPrincipal User admin,
            @RequestParam Place policlinic,
            @RequestParam String date_analysis,
            @RequestParam String result,
            Map<String, Object> model) {
        Analysis analysis = new Analysis(name_analysis, user, admin, policlinic, date_analysis, result);

        analysisRepo.save(analysis);

        Iterable<Analysis> analysises = analysisRepo.findAll();
        Iterable<User> users = usersRepo.findAll();
        Iterable<Place> places = placeRepo.findAll();

        model.put("analysises", analysises);
        model.put("users", users);
        model.put("places", places);

        return "analysis";
    }

    @GetMapping("/userAnalysis/{user}")
    public String userAnalysis(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Analysis analysis
    ) {
        //Iterable<Analysis> analysises = analysisRepo.findAll();
        List<Analysis> analysises = user.getAnalysises();

        model.addAttribute("analysises", analysises);
        model.addAttribute("analysis", analysis);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "userAnalysis";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/analysisList/delete/{analysis}")
    public String deleteAnalysis(
            @PathVariable Analysis analysis
    ){

        analysisRepo.deleteById(analysis.getIdanalysis());

        return "redirect:/analysisList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/analysisList")
    public String analysisList(Map<String, Object> model) {

        Iterable<Analysis> analysises = analysisRepo.findAll();

        model.put("analysises", analysises);

        return "analysisList";
    }
}
