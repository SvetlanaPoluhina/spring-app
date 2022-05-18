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
public class SickLeaveController {
    @Autowired
    private SickLeaveRepo sickleaveRepo;
    @Autowired
    private UserRepo usersRepo;
    @Autowired
    private PlaceRepo placeRepo;
    @Autowired
    private SickLeaveCodeRepo sickleave_codeRepo;

    @PreAuthorize("hasAuthority('DOCTOR')")
    @GetMapping("/sickleave")
    public String sickleave( Map<String, Object> model){
        Iterable<SickLeave> sickleaves = sickleaveRepo.findAll();
        Iterable<SickLeaveCode> codes = sickleave_codeRepo.findAll();
        Iterable<User> users = usersRepo.findAll();
        Iterable<Place> places = placeRepo.findAll();

        model.put("sickleaves", sickleaves);
        model.put("codes", codes);
        model.put("users", users);
        model.put("places", places);

        return "sickleave";
    }

    @PreAuthorize("hasAuthority('DOCTOR')")
    @PostMapping("/sickleave")
    public String addSickleave(
            @RequestParam User patient_sick,
            @RequestParam String date_sick,
            @AuthenticationPrincipal User doctor_sick,
            @RequestParam Place policlinic_sick,
            @RequestParam String ogrn,
            @RequestParam String place_work,
            @RequestParam String start_sick,
            @RequestParam String end_sick,
            @RequestParam SickLeaveCode code_sick,
            Map<String, Object> model) {

        SickLeave sickleave = new SickLeave (patient_sick, doctor_sick, policlinic_sick, date_sick, ogrn, place_work,
                start_sick, end_sick, code_sick);

        sickleaveRepo.save(sickleave);

        Iterable<SickLeave> sickleaves = sickleaveRepo.findAll();
        Iterable<SickLeaveCode> codes = sickleave_codeRepo.findAll();
        Iterable<User> users = usersRepo.findAll();
        Iterable<Place> places = placeRepo.findAll();

        model.put("sickleaves", sickleaves);
        model.put("codes", codes);
        model.put("users", users);
        model.put("places", places);

        return "sickleave";
    }

    @GetMapping("/userSickleave/{user}")
    public String userSickleave(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) SickLeave sickleave
    ) {
        List<SickLeave> sickleaves = user.getSickleaves();

        model.addAttribute("sickleaves", sickleaves);
        model.addAttribute("sickleave", sickleave);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "userSickleave";
    }

    @GetMapping("/sickleave/{sickleave}")
    public String userOneSickLeave (Model model, @PathVariable SickLeave sickleave) {


        model.addAttribute("patient_sickName", sickleave.getPatient_sickName());
        model.addAttribute("birthday", sickleave.getPatient_sickBirthday());
        model.addAttribute("date_sick", sickleave.getDate_sick());
        model.addAttribute("ogrn", sickleave.getOgrn());
        model.addAttribute("place_work", sickleave.getPlace_work());
        model.addAttribute("doctor_sickName", sickleave.getDoctor_sickName());
        model.addAttribute("start_sick", sickleave.getStart_sick());
        model.addAttribute("policlinic_sickName", sickleave.getPoliclinic_sickName());
        model.addAttribute("end_sick", sickleave.getEnd_sick());
        model.addAttribute("code_sickName", sickleave.getCodeName());

        return "userOneSickleave";
    }
}
