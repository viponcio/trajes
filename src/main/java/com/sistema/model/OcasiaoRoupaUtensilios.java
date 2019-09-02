package com.sistema.model;

public class OcasiaoRoupaUtensilios {
    public String descricao;

    public int codRoupaUtensilios;

    public OcasiaoRoupaUtensilios(){

    }

    public OcasiaoRoupaUtensilios(String descricao, int codRoupaUtensilios) {
        this.descricao = descricao;
        this.codRoupaUtensilios = codRoupaUtensilios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodRoupaUtensilios() {
        return codRoupaUtensilios;
    }

    public void setCodRoupaUtensilios(int codRoupaUtensilios) {
        this.codRoupaUtensilios = codRoupaUtensilios;
    }
}
