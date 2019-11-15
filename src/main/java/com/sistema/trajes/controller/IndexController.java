package com.sistema.trajes.controller;

import com.sistema.model.Funcionario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller//anotação

public class IndexController {
    @RequestMapping("/index")
    public String index(Funcionario funcionario, Model model, HttpSession session){
//        index<String,funcionario> funcionario = getNomeFunc(session);
        return "index";
    }
}
