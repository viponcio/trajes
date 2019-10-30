package com.sistema.trajes.controller;

import com.sistema.model.Funcionario;
import com.sistema.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;


    @RequestMapping("/cadastrarFuncionario")
    public String form(){

        return "cadastroFuncionario";
    }

    //vou alterar o value do request mapping,trocar cadastrarFuncionario por cadastroFuncionario e o nome do metodo por salvar
    @RequestMapping(value="/cadastroFuncionario" , method = RequestMethod.POST)//é por aqui q o browser vai achar localhost:8080/cadastrarFuncionario
    public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes ){
        funcionarioRepository.save(funcionario);
        return("redirect:/dashboard");
    }

    @RequestMapping(value="/entrar")
    @GetMapping(path = "/{idFunc}")
    public ResponseEntity<?>getFuncionarioById(@PathVariable ("idFunc")Long idFunc){
        Funcionario funcionario = funcionarioRepository.findById(idFunc).get();

        if(funcionario == null){
            return new ResponseEntity<>(new Error() , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(funcionario,HttpStatus.OK);
    }
//    @GetMapping(path="/{idCli}")//posso ler o cliente pegando pelo id
//    public ResponseEntity<?>getCliById(@PathVariable("idCli")Long idCli){
//        Cliente cliente=cli.findById(idCli).get();
//
//        if(cliente==null){
//            return new ResponseEntity<>( new Error() , HttpStatus.NOT_FOUND);
//
//        }
//        return new ResponseEntity<>(cliente,HttpStatus.OK);
//    }
}
