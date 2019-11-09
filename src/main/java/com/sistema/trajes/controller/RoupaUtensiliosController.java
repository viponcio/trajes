package com.sistema.trajes.controller;

import com.sistema.model.RoupaUtensilios;
import com.sistema.model.TipoRoupa;
import com.sistema.repository.RoupaUtensiliosRepository;
import com.sistema.repository.TipoRoupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RoupaUtensiliosController {
    @Autowired
    RoupaUtensiliosRepository roupaUtensiliosRepository;

    @Autowired
    TipoRoupaRepository tipoRoupaRepository;

    @RequestMapping("/gerenciarRoupaUtensilios")//vai mudar mais tarde quando houver trajes
    public String gerenciarRoupaUtensilios(){
        return "gerenciarRoupaUtensilios";
    }

    @RequestMapping("/cadastrarRoupaUtensilios")
    public String cadastrarRoupaUtensilios(){

        return "cadastrarRoupaUtensilios";
    }

    @RequestMapping(value="/salvarRoupaUtensilios", method = RequestMethod.POST)
    public ModelAndView salvarRoupaUtensilios(RoupaUtensilios roupaUtensilios,TipoRoupa tipoRoupa){
        roupaUtensiliosRepository.save(roupaUtensilios);
        tipoRoupaRepository.save(tipoRoupa);
        return new ModelAndView("redirect:/gerenciarRoupaUtensilios");
    }

}
