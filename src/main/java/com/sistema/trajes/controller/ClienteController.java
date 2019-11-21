package com.sistema.trajes.controller;

import com.sistema.dao.ClienteDao;
import com.sistema.model.Cliente;
import com.sistema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Controller//anotação
public class ClienteController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteDao dao;

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
    public String excluirCli(long idCli,RedirectAttributes attrib){
        Optional<Cliente> cli = clienteRepository.findById(idCli);
        clienteRepository.deleteById(idCli);
        attrib.addFlashAttribute("message", "Cliente removido com sucesso.");
        return "redirect:/gerenciarCli";
    }


    @GetMapping("/nomeCli")
    public ModelAndView acharNome(@RequestParam("nomeCli") String nomeCli, ModelMap model){//lista o meu cliente encontrado pelo nome
        if(nomeCli == null){
            System.out.println("entrou");

            return new ModelAndView("redirect:/gerenciarCli");

        }
//        Cliente cli = new Cliente();
        System.out.println("nome:"+nomeCli);
        model.addAttribute("clientes", dao.getByNomeCli(nomeCli));
        return new ModelAndView("acharNome",model);

    }

//    @RequestMapping(value = "listarNome" , method = RequestMethod.POST)
//    public ModelAndView listarNome(@RequestParam("nomeCli") String nomeCli,Model model){
//        ModelAndView mv = new ModelAndView("acharNome");
//        Optional<Cliente> cliente = clienteRepository.findByNomeCli("nomeCli");//primeiro tem q buscar os clientes
//        mv.addObject("cliente",cliente);
//
//        return mv;
//    }


}
