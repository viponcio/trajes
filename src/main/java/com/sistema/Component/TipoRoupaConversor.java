package com.sistema.Component;

import com.sistema.repository.TipoRoupaRepository;
import com.sistema.trajes.controller.RoupaUtensiliosController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
//Você não deve usar o name="tipoRoupa" quando usa o th:field. O th:field será transformado em
//name quando a página for renderizada.
//Você tem que criar um conversor que pegue o codTipoRoupa e transforme em um objeto TipoRoupa. Crie uma

@Component
public class TipoRoupaConversor implements Converter<String, String> {

    @Autowired
    private TipoRoupaRepository tipoRoupaRepository;

    @Autowired
    private RoupaUtensiliosController roupaUtensiliosController;

    @Override
    public String convert(String descricao) {
        //transforma o valor enviado pelo combo no tido esperado
        Long codTipoRoupa = Long.valueOf(descricao);
        return descricao;
    }
}
//    public Departamento convert(String text) {
//        if (text.isEmpty()) {
//            return null;
//        }
//
//        Long id = Long.valueOf(text);
//        return service.buscarPorId(id);
//    }

