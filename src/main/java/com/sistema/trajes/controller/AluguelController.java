package com.sistema.trajes.controller;

import com.sistema.dao.AluguelDaoImp;
import com.sistema.dao.ClienteDao;
import com.sistema.model.Aluguel;
import com.sistema.model.Cliente;
import com.sistema.model.TipoRoupa;
import com.sistema.repository.AluguelRepository;
import com.sistema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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
    @RequestMapping("/gerenciarAluguel")
    public ModelAndView gerenciarAluguel(String nomeCli){//só para a pag inicial do gerenciar akuguel
        ModelAndView mv = new ModelAndView("gerenciarAluguel");
//        Cliente cliente1 = clienteRepository.findByNomeCli(nomeCli);
//        System.out.println(""+cliente1.getNomeCli());
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
    public ModelAndView acharNomeAluguel(@RequestParam("nomeCli") String nomeCli, ModelMap model, RedirectAttributes redirectAttributes){//lista o meu cliente encontrado pelo nome
        if(nomeCli.length() == 0){//se não for digitado nada ele retorna
            redirectAttributes.addFlashAttribute("message", "Foi digitado nada.");
            return new ModelAndView("redirect:/gerenciarAluguel");


        }
    //        Cliente cli = new Cliente();
        System.out.println("nome:"+nomeCli);
        model.addAttribute("clientes", dao.getByNomeCli(nomeCli));
        return new ModelAndView("acharNomeAluguel",model);

        }

    @RequestMapping(value = "/escolherTraje" , method = RequestMethod.GET)
    public ModelAndView  escolherTraje(@RequestParam("idCli") Long idCli, Model model){
        ModelAndView mv = new ModelAndView("escolherTraje");
        Optional<Cliente> cliente = this.clienteRepository.findById(idCli);

        mv.addObject("cliente",cliente);
        return mv;

    }
    @RequestMapping(value = "/cadastrarAluguel",method = RequestMethod.POST)
    public ModelAndView cadastrarAluguel (Cliente cliente, Aluguel aluguel,ModelMap model){
        System.out.println("cadastro do aluguel");
//        SchoolClass schoolClass = schoolClassService.getSchoolClassById(idSchoolClass);
//
//        schoolClass.getId();
//
//        student.setSchollClass(schoolClass);
//
//        studentService.saveStudent(student);
//        System.out.println("numerooo:"+aluguel1.getCliente().getIdCli());
        aluguelRepository.save(aluguel);
        return new ModelAndView("/gerenciarAluguel");
    }

}
