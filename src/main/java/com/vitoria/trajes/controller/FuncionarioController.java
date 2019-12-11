package com.vitoria.trajes.controller;

import com.vitoria.model.Funcionario;
import com.vitoria.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;

import static java.lang.Class.forName;

@Controller
public class FuncionarioController extends HttpServlet {
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


}
