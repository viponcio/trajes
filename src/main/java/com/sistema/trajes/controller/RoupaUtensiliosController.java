package com.sistema.trajes.controller;

import com.sistema.model.RoupaUtensilios;
import com.sistema.model.TipoRoupa;
import com.sistema.repository.RoupaUtensiliosRepository;
import com.sistema.repository.TipoRoupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class RoupaUtensiliosController {
    @Autowired
    RoupaUtensiliosRepository roupaUtensiliosRepository;

    @Autowired
    TipoRoupaRepository tipoRoupaRepository;

    @RequestMapping("/gerenciarRoupaUtensilios")
    public ModelAndView gerenciarRoupaUtensilios(){
        ModelAndView mv = new ModelAndView("gerenciarRoupaUtensilios");
        Iterable<RoupaUtensilios> roupaUtensilios = roupaUtensiliosRepository.findAll();
        mv.addObject("roupaUtensilios",roupaUtensilios);

        Iterable<TipoRoupa> tipoRoupa = tipoRoupaRepository.findAll();
        mv.addObject("tipoRoupa",tipoRoupa);
        return mv;

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

    @RequestMapping(value = "/buscarRoupaUtensilios" , method = RequestMethod.GET)
    public ModelAndView buscarRoupaUtensilios(@RequestParam("codRoupaUtensilios") Long codRoupaUtensilios , Model model){
        ModelAndView mv = new ModelAndView("gerenciarAluguel");
        Optional<RoupaUtensilios> roupaUtensilios = this.roupaUtensiliosRepository.findById(codRoupaUtensilios);
        mv.addObject("roupaUtensilios",roupaUtensilios);
        return mv;
    }

//    @RequestMapping(value = "/buscarCli" , method = RequestMethod.GET)
//    public ModelAndView  buscarCli(@RequestParam("idCli") Long idCli, Model model){
//        ModelAndView mv = new ModelAndView("editarCli");
//        Optional<Cliente> cliente = this.clienteRepository.findById(idCli);
//        mv.addObject("cliente",cliente);
//        return mv;
//
//    }
}
