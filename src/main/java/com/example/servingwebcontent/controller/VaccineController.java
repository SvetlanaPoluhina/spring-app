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
public class VaccineController {
    @Autowired
    private VaccineRepo vaccineRepo;
    @Autowired
    private UserRepo usersRepo;
    @Autowired
    private PlaceRepo placeRepo;

    @PreAuthorize("hasAuthority('DOCTOR')")
    @GetMapping("/vaccines")
    public String vaccine( Map<String, Object> model){
        Iterable<Vaccine> vaccines = vaccineRepo.findAll();
        Iterable<User> users = usersRepo.findAll();
        Iterable<Place> places = placeRepo.findAll();

        model.put("vaccines", vaccines);
        model.put("users", users);
        model.put("places", places);

        return "vaccine";
    }

    @PreAuthorize("hasAuthority('DOCTOR')")
    @PostMapping("/vaccines")
    public String add_vaccine(
            @RequestParam User patient_vac,
            @RequestParam String name_vaccine,
            @AuthenticationPrincipal User admin_vac,
            @RequestParam Place poliklinik,
            @RequestParam String name_preparate,
            @RequestParam String date,
            @RequestParam String dose_vaccine,
            @RequestParam String country_vaccine,
            @RequestParam String result_tuberdiagnoz,
            Map<String, Object> model) {
        Vaccine vaccine = new Vaccine(name_vaccine, patient_vac, admin_vac, poliklinik, name_preparate, date, dose_vaccine, country_vaccine, result_tuberdiagnoz);

        vaccineRepo.save(vaccine);

        Iterable<Vaccine> vaccines = vaccineRepo.findAll();
        Iterable<User> users = usersRepo.findAll();
        Iterable<Place> places = placeRepo.findAll();

        model.put("vaccines", vaccines);
        model.put("users", users);
        model.put("places", places);

        return "vaccine";
    }

    @GetMapping("/userVaccine/{patient_vac}")
    public String userVaccine(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User patient_vac,
            Model model,
            @RequestParam(required = false) Vaccine vaccine
    ) {
        //Iterable<Analysis> analysises = analysisRepo.findAll();
        List<Vaccine> vaccines = patient_vac.getVaccines();

        model.addAttribute("vaccines", vaccines);
        model.addAttribute("vaccine", vaccine);
        model.addAttribute("isCurrentUser", currentUser.equals(patient_vac));

        return "userVaccine";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/vaccineList/delete/{vaccine}")
    public String deleteVaccine(
            @PathVariable Vaccine vaccine
    ){

        vaccineRepo.deleteById(vaccine.getIdvaccine());

        return "redirect:/vaccineList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/vaccineList")
    public String vaccineList(Map<String, Object> model) {

        Iterable<Vaccine> vaccines = vaccineRepo.findAll();

        model.put("vaccines", vaccines);

        return "vaccineList";
    }
}
