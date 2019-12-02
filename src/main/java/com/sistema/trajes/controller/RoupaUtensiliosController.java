package com.sistema.trajes.controller;

import com.sistema.Component.TipoRoupaConversor;
import com.sistema.dao.RoupaUtensiliosDao;
import com.sistema.model.RoupaUtensilios;
import com.sistema.model.TipoRoupa;
import com.sistema.repository.RoupaUtensiliosRepository;
import com.sistema.repository.TipoRoupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class RoupaUtensiliosController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RoupaUtensiliosDao dao;

    @Autowired
    RoupaUtensiliosRepository roupaUtensiliosRepository;

    @Autowired
    TipoRoupaRepository tipoRoupaRepository;

    @RequestMapping("/gerenciarRoupaUtensilios")
    public ModelAndView gerenciarRoupaUtensilios(){
        ModelAndView mv = new ModelAndView("gerenciarRoupaUtensilios");
        Iterable<RoupaUtensilios> roupaUtensilios = roupaUtensiliosRepository.findAll();
        mv.addObject("roupaUtensilios",roupaUtensilios);

        Iterable<TipoRoupa> tipoRoupa = tipoRoupaRepository.findAll();
        mv.addObject("tipoRoupa",tipoRoupa);
        System.out.println("tipos:"+tipoRoupaRepository.findAll());
        return mv;

    }

    @RequestMapping("/cadastrarRoupaUtensilios")
    public ModelAndView cadastrarRoupaUtensilios(){
        ModelAndView mv = new ModelAndView("cadastrarRoupaUtensilios");
        System.out.println("entrou cadastrar");
        List<TipoRoupa> tipoRoupa = tipoRoupaRepository.findAll();

        mv.addObject("tipoRoupa",tipoRoupa);
        return mv;
    }

    @RequestMapping(value="/salvarRoupaUtensilios", method = RequestMethod.POST)
    public ModelAndView salvarRoupaUtensilios(HttpServletRequest request, RoupaUtensilios roupaUtensilios, TipoRoupa tipoRoupa, Long idTipoRoupa){
//        if (idTipoRoupa != null) {
//            roupaUtensilios.setTipoRoupa(tipoRoupaRepository.findById(idTipoRoupa).get());
//        }

        roupaUtensiliosRepository.save(roupaUtensilios);

        return new ModelAndView("redirect:/gerenciarRoupaUtensilios");
    }

    @RequestMapping(value = "/buscarRoupaUtensilios" , method = RequestMethod.GET)
    public ModelAndView buscarRoupaUtensilios(@RequestParam("codRoupaUtensilios") Long codRoupaUtensilios,@RequestParam("codTipoRoupa") Long codTipoRoupa, Model model){
        System.out.println("cod:"+codRoupaUtensilios);
        System.out.println("");
        ModelAndView mv = new ModelAndView("editarRoupaUtensilios");
        Optional<RoupaUtensilios> roupaU = this.roupaUtensiliosRepository.findById(codRoupaUtensilios);
        mv.addObject("roupaU",roupaU);
        return mv;
    }

    @RequestMapping(value="/editarRoupaUtensilios")
    public ModelAndView editarRoupaUtensilios(RoupaUtensilios roupaUtensilios){
        roupaUtensiliosRepository.save(roupaUtensilios);
        return new ModelAndView("redirect:/gerenciarRoupaUtensilios");
    }

    @GetMapping("/cor")
    public ModelAndView acharCor(@RequestParam("cor") String cor, ModelMap model){//lista a cor encontrado
        if(cor.length() == 0){
            System.out.println("cor veio nula");
            return new ModelAndView("redirect:/gerenciarRoupaUtensilios");

        }
        System.out.println("nome:"+cor);
        model.addAttribute("cores", dao.getByCor(cor));
        return new ModelAndView("acharRoupaUtensilios",model);

    }

    @RequestMapping("excluirRoupaUtensilios")
    public String excluirRoupaUtensilios(long codRoupaUtensilios,RedirectAttributes attrib){
        Optional<RoupaUtensilios> roupaUtensilios = roupaUtensiliosRepository.findById(codRoupaUtensilios);
        roupaUtensiliosRepository.deleteById(codRoupaUtensilios);
        attrib.addFlashAttribute("message", "Roupa ou Utensílio removido com sucesso.");
        return "redirect:/gerenciarRoupaUtensilios";
    }
}
