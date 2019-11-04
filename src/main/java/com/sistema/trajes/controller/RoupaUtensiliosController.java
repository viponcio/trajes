package com.sistema.trajes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoupaUtensiliosController {
    @RequestMapping("/gerenciarTrajes")
    public String gerenciarTrajes(){
        return "gerenciarTrajes";
    }

    @RequestMapping("/cadastrarTrajes")
    public String cadastrarTrajes(){
        return "cadastrarTrajes";
    }

    @RequestMapping("/salvarTrajes")
    public String salvarTrajes(){
        return "salvarTrajes";
    }
}
