package com.sistema.trajes.controller;

import com.sistema.model.Cliente;
import com.sistema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Controller//anotação
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping("/cadastrarCli")
    public String cadastrarCli(){
        return "cadastrarCli";
    }

    @RequestMapping("/gerenciarCli")//gerenciarCli vai listar os clientes
    public ModelAndView gerenciarCli(){
        ModelAndView mv = new ModelAndView("gerenciarCli");
        Iterable<Cliente> clientes = clienteRepository.findAll();//primeiro tem q buscar os clientes
        mv.addObject("clientes",clientes);
        return mv;
    }


    //BidingResults vai servir para validar apenas se o meu formulário não vai estar vazio
    @RequestMapping(value = "/salvarCli",method = RequestMethod.POST)
    public ModelAndView salvarCliente(Cliente cliente,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
        clienteRepository.save(cliente);
        return new ModelAndView("redirect:/");

    }

    @RequestMapping(value = "/buscarCli" , method = RequestMethod.GET)
    public ModelAndView  buscarCli(@RequestParam("idCli") Long idCli, Model model){
        ModelAndView mv = new ModelAndView("editarCli");
        Optional<Cliente> cliente = this.clienteRepository.findById(idCli);
        mv.addObject("cliente",cliente);
        return mv;

    }

    @RequestMapping(value="/{idCli}" ,method = RequestMethod.POST)
    public String editarCli(@PathVariable("idCli") Long idCli, Model model){
        Cliente cliente = clienteRepository.findById(idCli).orElseThrow(()->new IllegalArgumentException("Usuário Incorreto:"+idCli));
        model.addAttribute("cliente",cliente);
//        ModelAndView mv = new ModelAndView("/gerenciarCli");
        return "gerenciarCli";
    }



}
