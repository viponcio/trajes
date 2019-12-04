package com.sistema.trajes.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//anotação

public class LoginController {

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null){model.addAttribute("error", "E-mail ou senha incorretos.");}


        if (logout != null){model.addAttribute("message", "Você saiu da aplicação.");}

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("username: " + auth.getName());
        return "login";
    }
}

