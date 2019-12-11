package com.vitoria.trajes.controller;

import com.vitoria.dao.RoupaUtensiliosDao;
import com.vitoria.model.RoupaUtensilios;
import com.vitoria.model.TipoRoupa;
import com.vitoria.repository.RoupaUtensiliosRepository;
import com.vitoria.repository.TipoRoupaRepository;
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

        return mv;

    }

    @RequestMapping("/cadastrarRoupaUtensilios")
    public ModelAndView cadastrarRoupaUtensilios(RoupaUtensilios roupaUtensilios){
        ModelAndView mv = new ModelAndView("cadastrarRoupaUtensilios");
        System.out.println("entrou cadastrar");
        List<TipoRoupa> tipoRoupa = tipoRoupaRepository.findAll();
        mv.addObject("tiposRoupa",tipoRoupa);
        return mv;
    }

    @RequestMapping(value="/salvarRoupaUtensilios", method = RequestMethod.POST)
    public ModelAndView salvarRoupaUtensilios(HttpServletRequest request, RoupaUtensilios roupaUtensilios, Long codTipoRoupa){
        System.out.println(roupaUtensilios);
        if (roupaUtensilios.getCodTipoRoupa() != null) {
            roupaUtensilios.setTipoRoupa(tipoRoupaRepository.findById(roupaUtensilios.getCodTipoRoupa()).get());
        }
        System.out.println("codigo tipo:"+roupaUtensilios.getCodTipoRoupa());


        roupaUtensiliosRepository.saveAndFlush(roupaUtensilios);

        return new ModelAndView("redirect:/gerenciarRoupaUtensilios");
    }

    @RequestMapping(value = "/buscarRoupaUtensilios" , method = RequestMethod.GET)
    public ModelAndView buscarRoupaUtensilios(@RequestParam("codRoupaUtensilios") Long codRoupaUtensilios, Model model){

        ModelAndView mv = new ModelAndView("editarRoupaUtensilios");
        Optional<RoupaUtensilios> roupaU = this.roupaUtensiliosRepository.findById(codRoupaUtensilios);
        mv.addObject("roupaU",roupaU.get());
        List<TipoRoupa> tipoRoupa = tipoRoupaRepository.findAll();
        mv.addObject("tiposRoupa",tipoRoupa);
        return mv;
    }

    @RequestMapping(value="/editarRoupaUtensilios", method = RequestMethod.POST)
    public ModelAndView editarRoupaUtensilios(RoupaUtensilios roupaUtensilios,TipoRoupa tipoRoupa,ModelMap mm){
//        tipoRoupaRepository.save(tipoRoupa);//se eu dar update na chave estrangeira ela não funciona,tentar fazer na mão
//        roupaUtensiliosRepository.save(roupaUtensilios);

        mm.addAttribute("roupaUtensilios",dao.alterar(roupaUtensilios));
        return new ModelAndView("redirect:/gerenciarRoupaUtensilios");
    }

    @GetMapping("/cor")
    public ModelAndView acharCor(@RequestParam("cor") String cor, ModelMap model,RedirectAttributes att){//lista a cor encontrado
        if(cor.isEmpty()){
            att.addFlashAttribute("message","Busca em branco");
            return new ModelAndView("redirect:/gerenciarRoupaUtensilios");
        }
        if(cor.length() <=2){
            att.addFlashAttribute("message","Digite novamente,nada foi encontrado");
            return new ModelAndView("redirect:/gerenciarRoupaUtensilios");
        }
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
