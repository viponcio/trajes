package com.sistema.model;

public class RoupaUtensilios {
    private int codRoupaUtensilios;

    private int tamanho;

    private float precoRoupaUtensilio;

    private String caracRoupaUtensilios;

    private int quantidade;

    public RoupaUtensilios(){

    }

    public RoupaUtensilios(int codRoupaUtensilios, int tamanho, float precoRoupaUtensilio, String caracRoupaUtensilios, int quantidade) {
        this.codRoupaUtensilios = codRoupaUtensilios;
        this.tamanho = tamanho;
        this.precoRoupaUtensilio = precoRoupaUtensilio;
        this.caracRoupaUtensilios = caracRoupaUtensilios;
        this.quantidade = quantidade;
    }

    public int getCodRoupaUtensilios() {
        return codRoupaUtensilios;
    }

    public void setCodRoupaUtensilios(int codRoupaUtensilios) {
        this.codRoupaUtensilios = codRoupaUtensilios;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public float getPrecoRoupaUtensilio() {
        return precoRoupaUtensilio;
    }

    public void setPrecoRoupaUtensilio(float precoRoupaUtensilio) {
        this.precoRoupaUtensilio = precoRoupaUtensilio;
    }

    public String getCaracRoupaUtensilios() {
        return caracRoupaUtensilios;
    }

    public void setCaracRoupaUtensilios(String caracRoupaUtensilios) {
        this.caracRoupaUtensilios = caracRoupaUtensilios;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
