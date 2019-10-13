package com.sistema.model;
import javax.persistence.*;
import java.io.Serializable;
@Entity

public class Funcionario implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFunc;

    @Column
    private String nomeFunc;
    private String sobrenomeFunc;
    private String emailFunc;
    private String senhaFunc;
    private String foneFunc;
    private String ruaFunc;
    private String cepFunc;
    private String bairroFunc;
    private int numeroFunc;
    private String generoFunc;
    private String cpfFunc;
    private String nascimentoFunc;
    private String estadoFunc;
    private String cidadeFunc;

    public Funcionario(){

    }

    public Funcionario(Long idFunc, String nomeFunc, String sobrenomeFunc, String emailFunc, String senhaFunc, String foneFunc, String ruaFunc, String cepFunc, String bairroFunc, int numeroFunc, String generoFunc, String cpfFunc, String nascimentoFunc, String estadoFunc, String cidadeFunc) {
        this.idFunc = idFunc;
        this.nomeFunc = nomeFunc;
        this.sobrenomeFunc = sobrenomeFunc;
        this.emailFunc = emailFunc;
        this.senhaFunc = senhaFunc;
        this.foneFunc = foneFunc;
        this.ruaFunc = ruaFunc;
        this.cepFunc = cepFunc;
        this.bairroFunc = bairroFunc;
        this.numeroFunc = numeroFunc;
        this.generoFunc = generoFunc;
        this.cpfFunc = cpfFunc;
        this.nascimentoFunc = nascimentoFunc;
        this.estadoFunc = estadoFunc;
        this.cidadeFunc = cidadeFunc;
    }

    public Long getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Long  idFunc) {
        this.idFunc = idFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getSobrenomeFunc() {
        return sobrenomeFunc;
    }

    public void setSobrenomeFunc(String sobrenomeFunc) {
        this.sobrenomeFunc = sobrenomeFunc;
    }

    public String getEmailFunc() {
        return emailFunc;
    }

    public void setEmailFunc(String emailFunc) {
        this.emailFunc = emailFunc;
    }

    public String getSenhaFunc() {
        return senhaFunc;
    }

    public void setSenhaFunc(String senhaFunc) {
        this.senhaFunc = senhaFunc;
    }

    public String getFoneFunc() {
        return foneFunc;
    }

    public void setFoneFunc(String foneFunc) {
        this.foneFunc = foneFunc;
    }

    public String getRuaFunc() {
        return ruaFunc;
    }

    public void setRuaFunc(String ruaFunc) {
        this.ruaFunc = ruaFunc;
    }

    public String getCepFunc() {
        return cepFunc;
    }

    public void setCepFunc(String cepFunc) {
        this.cepFunc = cepFunc;
    }

    public String getBairroFunc() {
        return bairroFunc;
    }

    public void setBairroFunc(String bairroFunc) {
        this.bairroFunc = bairroFunc;
    }

    public int getNumeroFunc() {
        return numeroFunc;
    }

    public void setNumeroFunc(int numeroFunc) {
        this.numeroFunc = numeroFunc;
    }

    public String getGeneroFunc() {
        return generoFunc;
    }

    public void setGeneroFunc(String generoFunc) {
        this.generoFunc = generoFunc;
    }

    public String getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(String cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public String getNascimentoFunc() {
        return nascimentoFunc;
    }

    public void setNascimentoFunc(String nascimentoFunc) {
        this.nascimentoFunc = nascimentoFunc;
    }

    public String getEstadoFunc() {
        return estadoFunc;
    }

    public void setEstadoFunc(String estadoFunc) {
        this.estadoFunc = estadoFunc;
    }

    public String getCidadeFunc() {
        return cidadeFunc;
    }

    public void setCidadeFunc(String cidadeFunc) {
        this.cidadeFunc = cidadeFunc;
    }
}
