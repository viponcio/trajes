package com.sistema.model;

public class ItensAlugados {
    private int codRoupaUtensilios;

    private int codAluguel;

    public ItensAlugados(){

    }

    public ItensAlugados(int codRoupaUtensilios, int codAluguel) {
        this.codRoupaUtensilios = codRoupaUtensilios;
        this.codAluguel = codAluguel;
    }

    public int getCodRoupaUtensilios() {
        return codRoupaUtensilios;
    }

    public void setCodRoupaUtensilios(int codRoupaUtensilios) {
        this.codRoupaUtensilios = codRoupaUtensilios;
    }

    public int getCodAluguel() {
        return codAluguel;
    }

    public void setCodAluguel(int codAluguel) {
        this.codAluguel = codAluguel;
    }
}
