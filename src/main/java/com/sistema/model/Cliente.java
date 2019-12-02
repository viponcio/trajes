package com.sistema.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
//essa classe o hibernate irá automaticamente se torna a tabela
@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCli;

    @Column()
    private String nomeCli;
    private String sobrenomeCli;
    private String emailCli;
    private String foneCli;
    private String ruaCli;
    private String cepCli;
    private String bairroCli;
    private String numeroCli;
    private String cpfCli;
    private String nascimentoCli;
    private String estadoCli;
    private String cidadeCli;

//    @OneToMany(mappedBy = "Cliente")
//    private Set<Aluguel> aluguels;

    public Cliente(Long idCli, String nomeCli, String sobrenomeCli, String emailCli, String foneCli, String ruaCli, String cepCli, String bairroCli, String numeroCli, String cpfCli, String nascimentoCli, String estadoCli, String cidadeCli) {
        this.idCli = idCli;
        this.nomeCli = nomeCli;
        this.sobrenomeCli = sobrenomeCli;
        this.emailCli = emailCli;
        this.foneCli = foneCli;
        this.ruaCli = ruaCli;
        this.cepCli = cepCli;
        this.bairroCli = bairroCli;
        this.numeroCli = numeroCli;
        this.cpfCli = cpfCli;
        this.nascimentoCli = nascimentoCli;
        this.estadoCli = estadoCli;
        this.cidadeCli = cidadeCli;
    }
    public Cliente(){

    }
    public Long getIdCli() {
        return idCli;
    }

    public void setIdCli(Long idCli) {
        this.idCli = idCli;
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public String getSobrenomeCli() {
        return sobrenomeCli;
    }

    public void setSobrenomeCli(String sobrenomeCli) {
        this.sobrenomeCli = sobrenomeCli;
    }

    public String getEmailCli() {
        return emailCli;
    }

    public void setEmailCli(String emailCli) {
        this.emailCli = emailCli;
    }

    public String getFoneCli() {
        return foneCli;
    }

    public void setFoneCli(String foneCli) {
        this.foneCli = foneCli;
    }

    public String getRuaCli() {
        return ruaCli;
    }

    public void setRuaCli(String ruaCli) {
        this.ruaCli = ruaCli;
    }

    public String getCepCli() {
        return cepCli;
    }

    public void setCepCli(String cepCli) {
        this.cepCli = cepCli;
    }

    public String getBairroCli() {
        return bairroCli;
    }

    public void setBairroCli(String bairroCli) {
        this.bairroCli = bairroCli;
    }

    public String getNumeroCli() {
        return numeroCli;
    }

    public void setNumeroCli(String numeroCli) {
        this.numeroCli = numeroCli;
    }

    public String getCpfCli() {
        return cpfCli;
    }

    public void setCpfCli(String cpfCli) {
        this.cpfCli = cpfCli;
    }

    public String getNascimentoCli() {
        return nascimentoCli;
    }

    public void setNascimentoCli(String nascimentoCli) {
        this.nascimentoCli = nascimentoCli;
    }

    public String getEstadoCli() {
        return estadoCli;
    }

    public void setEstadoCli(String estadoCli) {
        this.estadoCli = estadoCli;
    }

    public String getCidadeCli() {
        return cidadeCli;
    }

    public void setCidadeCli(String cidadeCli) {
        this.cidadeCli = cidadeCli;
    }

//    public Set<Aluguel> getAluguels() {
//        return aluguels;
//    }
//
//    public void setAluguels(Set<Aluguel> aluguels) {
//        this.aluguels = aluguels;
//    }
}
