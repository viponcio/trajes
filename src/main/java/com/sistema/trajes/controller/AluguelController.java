package com.sistema.trajes.controller;

import com.sistema.dao.AluguelDaoImp;
import com.sistema.dao.ClienteDao;
import com.sistema.dao.RoupaUtensiliosDao;
import com.sistema.model.Aluguel;
import com.sistema.model.Cliente;
import com.sistema.model.RoupaUtensilios;
import com.sistema.model.TipoRoupa;
import com.sistema.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
@Controller
public class AluguelController extends HttpServlet {

    @Autowired
    private ClienteDao dao;

    private AluguelDaoImp aluguelDaoImp ;

    @Autowired
    AluguelRepository aluguelRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    RoupaUtensiliosRepository roupaUtensiliosRepository;

    @Autowired
    TipoRoupaRepository tipoRoupaRepository;

    @Autowired
    private RoupaUtensiliosDao rdao;

    @Autowired
    private RoupaAluguelRepository roupaAluguelRepository;


    @RequestMapping("/gerenciarAluguel")
    public ModelAndView gerenciarAluguel(String nomeCli){//só para a pag inicial do gerenciar aluguel
        ModelAndView mv = new ModelAndView("gerenciarAluguel");
        return mv;
    }

    @RequestMapping("/escolherData")
    public ModelAndView escolherData(@RequestParam("codRoupaUtensilios") Long codRoupaUtensilios,@RequestParam("idCli") Long idCli){
        ModelAndView mv = new ModelAndView("escolherData");
        return mv;
    }

    @RequestMapping("/atualizarData")
    public String atualizarData(){
        return ("atualizarData");
    }

    @RequestMapping("/atualizarRetirada")
    public String atualizarRetirada(){
        return ("atualizarRetirada");
    }

    @RequestMapping(method = RequestMethod.POST, path = "/nomeCli")
    public ModelAndView acharNomeAluguel(@RequestParam("nomeCli") String nomeCli, ModelMap model,Cliente cliente,RedirectAttributes redirectAttributes){//lista o meu cliente encontrado pelo nome
        if(nomeCli.length() == 0){//se não for digitado nada ele retorna
            redirectAttributes.addFlashAttribute("message", "Foi digitado nada.");
            return new ModelAndView("redirect:/gerenciarAluguel");


        }
    //        Cliente cli = new Cliente();
        System.out.println("nome:"+nomeCli);
        model.addAttribute("clientes", dao.getByNomeCli(nomeCli));
        return new ModelAndView("acharNomeAluguel",model);

        }

//    @RequestMapping(value = "/escolherTraje" , method = RequestMethod.GET)
//    public ModelAndView  escolherTraje(@RequestParam("idCli") Long idCli, Model model){
//        ModelAndView mv = new ModelAndView("escolherTraje");
//        Optional<Cliente> cliente = this.clienteRepository.findById(idCli);
//        System.out.println("id do cliente:"+idCli);
//        mv.addObject("cliente",cliente.get());
//        return mv;
//
//    }
    @RequestMapping("/escolherTraje")
    public ModelAndView escolherTraje(){
        ModelAndView mv = new ModelAndView("escolherTraje");
        Iterable<RoupaUtensilios> roupaUtensilios = roupaUtensiliosRepository.findAll();
        mv.addObject("roupaUtensilios",roupaUtensilios);
        Iterable<TipoRoupa> tipoRoupa = tipoRoupaRepository.findAll();
        mv.addObject("tipoRoupa",tipoRoupa);

        return mv;
    }

    @PostMapping("/cor")
    public ModelAndView acharRoupaUtensiliosAluguel(@RequestParam("cor") String cor, ModelMap model,RedirectAttributes att){//lista a cor encontrado
        if(cor.isEmpty()){
            att.addFlashAttribute("message","Busca em branco");
            return new ModelAndView("redirect:/escolherTraje");
        }
        if(cor.length() <=2){
            att.addFlashAttribute("message","Digite novamente,nada foi encontrado");
            return new ModelAndView("redirect:/escolherTraje");
        }
        model.addAttribute("cores", rdao.getByCor(cor));
        return new ModelAndView("acharRoupaUtensiliosAluguel",model);

    }

//
//    @RequestMapping("/acharRoupaUtensiliosAluguel")
//    public ModelAndView acharRoupaUtensiliosAluguel(){
//        return ModelAndView("acharRoupaUtensiliosAluguel");
//    }

    @RequestMapping(value = "/cadastrarAluguel" , method = RequestMethod.GET)
    public ModelAndView cadastrarAluguel(@RequestParam("codRoupaUtensilios") Long codRoupaUtensilios,@RequestParam("idCli") Long idCli,HttpServletRequest request, Aluguel aluguel){
        System.out.println(aluguel);
        if(aluguel.getIdCli()!= null){
            aluguel.setCliente(clienteRepository.findById(aluguel.getIdCli()).get());
        }

        aluguelRepository.saveAndFlush(aluguel);
        roupaAluguelRepository.saveAndFlush();
        return new ModelAndView("redirect:/gerenciarAluguel");

    }



}
