package com.sistema.trajes.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

//    public String getUsuarioLogado() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
//        usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
//        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            authentication.getName();
//        }
//        return authentication.getName();
//
//    }

}
