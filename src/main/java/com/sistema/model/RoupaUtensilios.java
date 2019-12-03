package com.sistema.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class RoupaUtensilios implements Serializable {
    private static final long serialVersionUID=1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id//tirei o generatedvalue pois sou eu q vou digitar  o cod
    private long codRoupaUtensilios;

    @Column
    private String tamanho;//deixar em char pois pode ser num ou palavra
    private float precoRoupaUtensilio;
    private String cor;

    private transient Long codTipoRoupa;

    public Long getCodTipoRoupa() {
        return codTipoRoupa;
    }

    public void setCodTipoRoupa(Long codTipoRoupa) {
        this.codTipoRoupa = codTipoRoupa;
    }

    @ManyToOne
    @JoinColumn(name = "codTipoRoupa")
    private TipoRoupa tipoRoupa;

    public TipoRoupa getTipoRoupa() {
        return tipoRoupa;
    }

    public void setTipoRoupa(TipoRoupa tipoRoupa) {
        this.tipoRoupa = tipoRoupa;
    }

    public RoupaUtensilios(){

    }

    public RoupaUtensilios(long codRoupaUtensilios, String tamanho, float precoRoupaUtensilio, String cor) {
        this.codRoupaUtensilios = codRoupaUtensilios;
        this.tamanho = tamanho;
        this.precoRoupaUtensilio = precoRoupaUtensilio;
        this.cor = cor;
    }

    public long getCodRoupaUtensilios() {
        return codRoupaUtensilios;
    }

    public void setCodRoupaUtensilios(long codRoupaUtensilios) {
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
