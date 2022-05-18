package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.*;
import com.example.servingwebcontent.repos.GroupBloodRepo;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private GroupBloodRepo groupBloodRepo;


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/user")
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());

        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/user/{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/user")
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        userService.saveUser(user, username, form);

        return "redirect:/user";
    }

    @GetMapping("/userProfile")
    public String userProfile(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("lastname", user.getLastname());
        model.addAttribute("firstname", user.getFirstname());
        model.addAttribute("patronymic", user.getPatronymic());
        model.addAttribute("birthday", user.getBirthday());
        model.addAttribute("policy_number", user.getPolicy_number());
        model.addAttribute("phone", user.getPhone());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("group_blood", user.getGroupName());

        return "userProfile";
    }

    @GetMapping("/userProfileEdit")
    public String userProfileEdit(Model model, @AuthenticationPrincipal User user) {
        Iterable<GroupBlood> groups = groupBloodRepo.findAll();
        model.addAttribute("username", user.getUsername());
        model.addAttribute("lastname", user.getLastname());
        model.addAttribute("firstname", user.getFirstname());
        model.addAttribute("patronymic", user.getPatronymic());
        model.addAttribute("birthday", user.getBirthday());
        model.addAttribute("policy_number", user.getPolicy_number());
        model.addAttribute("phone", user.getPhone());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("groups", groups);
        model.addAttribute("group_blood", user.getGroupName());

        return "userProfileEdit";
    }

    @PostMapping("/userProfileEdit")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String lastname,
            @RequestParam String firstname,
            @RequestParam String patronymic,
            @RequestParam String birthday,
            @RequestParam String policy_number,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam GroupBlood group_blood) {
        userService.updateProfile(user, password, lastname, firstname, patronymic, birthday, policy_number, phone, email, group_blood);

        return "redirect:/userProfile";
    }

}