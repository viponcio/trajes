package com.sistema.trajes.controller;

import com.sistema.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AluguelController {

    @Autowired
    AluguelRepository aluguelRepository;

    @RequestMapping("/gerenciarAluguel")
    public String gerenciarAluguel(){

        return "gerenciarAluguel";
    }

    @RequestMapping("/atualizarData")
    public String atualizarData(){
        return ("atualizarData");
    }

    @RequestMapping("/atualizarRetirada")
    public String atualizarRetirada(){
        return ("atualizarRetirada");
    }
}
