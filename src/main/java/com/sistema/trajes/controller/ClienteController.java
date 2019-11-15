package com.sistema.trajes.controller;

import com.sistema.model.Cliente;
import com.sistema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ModelAndView salvarCli(Cliente cliente,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
        clienteRepository.save(cliente);
        return new ModelAndView("redirect:/gerenciarCli");

    }

    @RequestMapping(value = "/buscarCli" , method = RequestMethod.GET)
    public ModelAndView  buscarCli(@RequestParam("idCli") Long idCli, Model model){
        ModelAndView mv = new ModelAndView("editarCli");
        Optional<Cliente> cliente = this.clienteRepository.findById(idCli);
        mv.addObject("cliente",cliente);
        return mv;

    }

    @RequestMapping(value="/editarCli")
    public ModelAndView editarCli(Cliente cliente){
        clienteRepository.save(cliente);
        return new ModelAndView("redirect:/gerenciarCli");
    }

    @RequestMapping("excluirCli")
    public String excluirCli(long idCli){
        Optional<Cliente> cli = clienteRepository.findById(idCli);
        clienteRepository.deleteById(idCli);
        return "redirect:/gerenciarCli";
    }



}
