package com.sistema.trajes.controller;

import com.sistema.DataConfiguration;
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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
//
//    @RequestMapping(value="/entrar" , method = RequestMethod.POST)
//    public String autenticar(Funcionario funcionario, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String emailFunc = req.getParameter("emailFunc");
//        String senhaFunc = req.getParameter("senhaFunc");
//        System.err.println(emailFunc + " " + senhaFunc);
//
//        RequestDispatcher disp;
//
//        Funcionario func = new Funcionario();
//        try (Connection conn = (Connection) new DataConfiguration().dataSource().getClass().forName("com.mysql.cj.jdbc.Driver")) {
//
//
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return 0;

//        return "cadastroFuncionario";
//    }

}
