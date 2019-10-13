package com.sistema.trajes.controller;

import com.sistema.model.Funcionario;
import com.sistema.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @RequestMapping("/cadastrarFuncionario")
    public String form(){

        return "cadastroFuncionario";
    }

    //vou alterar o velue do request mapping,trocar cadastrarFuncionario por cadastroFuncionario e o nome do metodo por salvar
    @RequestMapping(value="/cadastroFuncionario" , method = RequestMethod.POST)//é por aqui q o browser vai achar localhost:8080/cadastrarFuncionario
    public String salvar(Funcionario funcionario){
        funcionarioRepository.save(funcionario);
        return("redirect:/cadastrarFuncionario");
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
