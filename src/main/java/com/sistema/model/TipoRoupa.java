package com.sistema.model;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoRoupa implements Serializable{
    private static final long serialVersionUID=1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column
    private Long codTipoRoupa;
    private String descricao;
    @ManyToMany(mappedBy = "TipoRoupas", cascade = CascadeType.ALL)

    private List<RoupaUtensilios> roupaUtensiliosList;

    public TipoRoupa(){

    }



    public TipoRoupa(Long codTipoRoupa, String descricao) {
        this.codTipoRoupa = codTipoRoupa;
        this.descricao = descricao;
    }

    public Long getCodTipoRoupa() {
        return codTipoRoupa;
    }

    public void setCodTipoRoupa(Long codTipoRoupa) {
        this.codTipoRoupa = codTipoRoupa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<RoupaUtensilios> getRoupaUtensiliosList() {
        return roupaUtensiliosList;
    }

    public void setRoupaUtensiliosList(List<RoupaUtensilios> roupaUtensiliosList) {
        this.roupaUtensiliosList = roupaUtensiliosList;
    }
}
