package com.sistema.trajes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//anotação
public class ClienteController {
    @RequestMapping("/cadastrarCliente")
    public String form(){
        return "formularios/formCliente";
    }
}
