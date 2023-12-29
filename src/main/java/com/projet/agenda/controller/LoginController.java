package com.projet.agenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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


    //add request mapping for access-denied
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "/access-denied";
    }

    @GetMapping("/inscription")
    public String showSignUp(){
        return "inscription";
    }

}
