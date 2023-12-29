package com.projet.agenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "plain-login";
    }

    // request mapping for entrepreneurs
    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }

    //add request mapping for admin
    @GetMapping("/systems")
    public String showSystems(){ return "/systems";}

}
