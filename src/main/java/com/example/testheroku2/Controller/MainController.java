package com.example.testheroku2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //GET - code-90
    @GetMapping("/code-90")
    public String getCode90 (){

        return "/admin-templates/code-90";
    }
}
