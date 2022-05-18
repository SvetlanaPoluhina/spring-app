package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/greeting")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }
    @GetMapping("/")
    public String main(Map<String, Object> model){
        return "main";
    }

}