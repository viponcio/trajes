package com.sistema.trajes.controller;

import com.sistema.dao.ClienteDao;
import com.sistema.model.Cliente;
import com.sistema.model.Funcionario;
import com.sistema.model.TipoRoupa;
import com.sistema.repository.ClienteRepository;
import com.sistema.repository.TipoRoupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
@WebServlet(urlPatterns = "/clienteController")
@Controller//anotação
public class ClienteController extends HttpServlet {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteDao dao;



    @RequestMapping("/cadastrarCli")
    public String cadastrarCli(HttpServletRequest req){

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
        mv.addObject("cliente",cliente.get());
        return mv;

    }

    @RequestMapping(value="/editarCli")
    public ModelAndView editarCli(Cliente cliente){
        System.out.println("entrou no editarCli");
        clienteRepository.save(cliente);
        return new ModelAndView("redirect:/gerenciarCli");
    }

    @RequestMapping("excluirCli")
    public String excluirCli(long idCli,RedirectAttributes attrib,ModelMap model){
        System.out.println("entrou no excluir");


        Optional<Cliente> cli = clienteRepository.findById(idCli);
        clienteRepository.deleteById(idCli);
        model.addAttribute("exclui", "Cliente removido com sucesso.");
        return "redirect:/gerenciarCli";
    }


    @GetMapping("/nomeCli")
    public ModelAndView acharNome(@RequestParam("nomeCli") String nomeCli, ModelMap model,RedirectAttributes attributes){//lista o meu cliente encontrado pelo nome
        if(nomeCli.length() == 0){
            System.out.println("entrou");
            attributes.addFlashAttribute("message", "Foi digitado nada.");
            return new ModelAndView("redirect:/gerenciarCli");

        }
        if(nomeCli.length() < 2){
            attributes.addFlashAttribute("message", "Nome não encontrado.");
            return new ModelAndView("redirect:/gerenciarCli");
        }

//        Cliente cli = new Cliente();
        System.out.println();
        model.addAttribute("clientes", dao.getByNomeCli(nomeCli));
        return new ModelAndView("acharNome",model);


    }



}
