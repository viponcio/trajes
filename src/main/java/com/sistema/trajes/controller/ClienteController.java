package com.sistema.trajes.controller;

import com.sistema.model.Cliente;
import com.sistema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller//anotação
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping("/cadastrarCli")
    public String cadastrarCli(){
        return "cadastrarCli";
    }

    @RequestMapping("/gerenciarCli")
    public String gerenciarCli(){
        return "gerenciarCli";
    }

//    @RequestMapping(value ="/salvarCli" , method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public ResponseEntity<?> save (Cliente cliente){
//        return new ResponseEntity<>(clienteRepository.save(cliente), HttpStatus.OK);
//    }


//    @RequestMapping(value="/salvarCli" , method = RequestMethod.POST)//é por aqui q o browser vai achar localhost:8080/salvarCLi
//    public String salvar(Cliente cliente){
//        clienteRepository.save(cliente);
//        cliente.getBairroCli();
//        cliente.getCepCli();
//        cliente.getEmailCli();
//        return("redirect:/dashboard");
//    }

    @RequestMapping("/salvarCli")
    public ModelAndView salvarCliente(Cliente cliente) {
        cliente.getEmailCli();
        System.out.println("email:"+cliente.getEmailCli());
        System.out.println("nome:"+cliente.getNomeCli());
        System.out.println("fone:"+cliente.getFoneCli());
        System.out.println("cidade"+cliente.getCidadeCli());
        System.out.println("estado"+cliente.getEstadoCli());
        System.out.println("cep"+cliente.getCepCli());
        System.out.println("sobrenome"+cliente.getSobrenomeCli());
        clienteRepository.save(cliente);

        return new ModelAndView("redirect:/");

    }

    @RequestMapping("/editarCli")
    public String editarCli(){
        return "editarCli";
    }

    @RequestMapping("/gerenciarTrajes")
    public String gerenciarTrajes(){
        return "gerenciarTrajes";
    }

    @RequestMapping("/cadastrarTrajes")
    public String cadastrarTrajes(){
        return "cadastrarTrajes";
    }
}
