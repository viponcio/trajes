package com.sistema.trajes.controller;

import com.sistema.model.Aluguel;
import com.sistema.model.Cliente;
import com.sistema.repository.AluguelRepository;
import com.sistema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AluguelController {

    @Autowired
    AluguelRepository aluguelRepository;

    @Autowired
    ClienteRepository clienteRepository;
    @RequestMapping("/gerenciarAluguel")
    public ModelAndView gerenciarAluguel(String nomeCli){


        ModelAndView mv = new ModelAndView("gerenciarAluguel");
        Cliente cliente1 = clienteRepository.findByNomeCli(nomeCli);
//        System.out.println(""+cliente1.getNomeCli());
        return mv;
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
