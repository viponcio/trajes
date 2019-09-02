package com.sistema.model;

public class Funcionario {

    private int idFunc;

    private String nomeFunc;

    private String sobrenomeFunc;

    private String emailFunc;

    private String senhaFunc;

    private float foneFunc;

    private String ruaFunc;

    private String cepFunc;

    private String bairroFunc;

    private int numeroFunc;

    private String sexoFunc;

    private String cpfFunc;

    private String nascimentoFunc;

    private String estadoFunc;

    private String cidadeFunc;

    public Funcionario(){

    }

    public Funcionario(int idFunc, String nomeFunc, String sobrenomeFunc, String emailFunc, String senhaFunc, float foneFunc, String ruaFunc, String cepFunc, String bairroFunc, int numeroFunc, String sexoFunc, String cpfFunc, String nascimentoFunc, String estadoFunc, String cidadeFunc) {
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
        this.sexoFunc = sexoFunc;
        this.cpfFunc = cpfFunc;
        this.nascimentoFunc = nascimentoFunc;
        this.estadoFunc = estadoFunc;
        this.cidadeFunc = cidadeFunc;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
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

    public float getFoneFunc() {
        return foneFunc;
    }

    public void setFoneFunc(float foneFunc) {
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

    public String getSexoFunc() {
        return sexoFunc;
    }

    public void setSexoFunc(String sexoFunc) {
        this.sexoFunc = sexoFunc;
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
