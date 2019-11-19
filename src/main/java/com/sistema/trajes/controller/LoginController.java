package com.sistema.trajes.controller;

import com.sistema.model.Funcionario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller//anotação

public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

