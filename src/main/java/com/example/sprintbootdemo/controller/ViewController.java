package com.example.sprintbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/test/thymeleaf")
    public String testThymeleaf(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf !");
        return "index";
    }
}
