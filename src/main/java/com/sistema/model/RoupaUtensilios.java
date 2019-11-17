package com.sistema.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class RoupaUtensilios implements Serializable {
    private static final long serialVersionUID=1L;
    @Id//tirei o generatedvalue pois sou eu q vou digitar  o cod
    private Long codRoupaUtensilios;

    @Column
    private String tamanho;//deixar em char pois pode ser num ou palavra
    private float precoRoupaUtensilio;
    private String cor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "table_rt" , joinColumns={@JoinColumn(name = "tiporoupa_id")},
            inverseJoinColumns={@JoinColumn(name = "roupautensilios_id")})
    private List<TipoRoupa> TipoRoupas;

    public RoupaUtensilios(){

    }

    public RoupaUtensilios(Long codRoupaUtensilios, String tamanho, float precoRoupaUtensilio, String cor) {
        this.codRoupaUtensilios = codRoupaUtensilios;
        this.tamanho = tamanho;
        this.precoRoupaUtensilio = precoRoupaUtensilio;
        this.cor = cor;
    }

    public Long getCodRoupaUtensilios() {
        return codRoupaUtensilios;
    }

    public void setCodRoupaUtensilios(Long codRoupaUtensilios) {
        this.codRoupaUtensilios = codRoupaUtensilios;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public float getPrecoRoupaUtensilio() {
        return precoRoupaUtensilio;
    }

    public void setPrecoRoupaUtensilio(float precoRoupaUtensilio) {
        this.precoRoupaUtensilio = precoRoupaUtensilio;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}
