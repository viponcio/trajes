package com.sistema.model;

public class TipoRoupa {
    private int codTipoRoupa;

    private String tipo;

    public TipoRoupa(){

    }

    public TipoRoupa(int codTipoRoupa, String tipo) {
        this.codTipoRoupa = codTipoRoupa;
        this.tipo = tipo;
    }

    public int getCodTipoRoupa() {
        return codTipoRoupa;
    }

    public void setCodTipoRoupa(int codTipoRoupa) {
        this.codTipoRoupa = codTipoRoupa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
