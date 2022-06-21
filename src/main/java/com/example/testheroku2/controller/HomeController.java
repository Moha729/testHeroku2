package com.example.testheroku2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getIndex(){
        return "index5";
    }

    @GetMapping("/admin-code90")
    public String getAdminIndex(){
        return "/admin-templates/code-90";
    }
}
