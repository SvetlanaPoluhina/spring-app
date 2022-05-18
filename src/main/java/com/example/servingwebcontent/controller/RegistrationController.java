package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.GroupBlood;
import com.example.servingwebcontent.domain.Role;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.GroupBloodRepo;
import com.example.servingwebcontent.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private GroupBloodRepo groupBloodRepo;

    @GetMapping("/registration")
    public String registration(Map<String, Object> model) {
        Iterable<GroupBlood> groups = groupBloodRepo.findAll();
        model.put("groups", groups);
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {

        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "Пользователь с таким логином уже существует!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        Iterable<GroupBlood> groups = groupBloodRepo.findAll();
        model.put("groups", groups);

        return "redirect:/login";
    }
}