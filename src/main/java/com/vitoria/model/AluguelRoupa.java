package com.vitoria.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class AluguelRoupa implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codAluguelRoupa;

    //fazer ManytoOne e OneToMany,trocar pra checknox
    // @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Aluguel_Roupa", catalog = "trajesdb", joinColumns = { @JoinColumn(name = "codAluguel_FK", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "codRoupaUtensilios_FK", nullable = false) })
    private Set<RoupaUtensilios> RoupaUtensilioss;
//    private Set<Aluguel> aluguels;

    public Long getCodAluguelRoupa() {
        return codAluguelRoupa;
    }

    public void setCodAluguelRoupa(Long codAluguelRoupa) {
        this.codAluguelRoupa = codAluguelRoupa;
    }

    public Set<RoupaUtensilios> getRoupaUtensilioss() {
        return RoupaUtensilioss;
    }

    public void setRoupaUtensilioss(Set<RoupaUtensilios> roupaUtensilioss) {
        RoupaUtensilioss = roupaUtensilioss;
    }


}
