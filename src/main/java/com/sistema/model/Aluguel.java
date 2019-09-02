package com.sistema.model;

import java.util.Date;

public class Aluguel {
    private int idCli;

    private int idRoupaUtensilios;

    private float preco;

    private Date dataEvento;

    private Date dataProva;

    private Date dataRetirada;

    private Date dataEntrega;

    private int idFunc;

    private int codAluguel;

    public Aluguel(){

    }

    public Aluguel(int idCli, int idRoupaUtensilios, float preco, Date dataEvento, Date dataProva, Date dataRetirada, Date dataEntrega, int idFunc, int codAluguel) {
        this.idCli = idCli;
        this.idRoupaUtensilios = idRoupaUtensilios;
        this.preco = preco;
        this.dataEvento = dataEvento;
        this.dataProva = dataProva;
        this.dataRetirada = dataRetirada;
        this.dataEntrega = dataEntrega;
        this.idFunc = idFunc;
        this.codAluguel = codAluguel;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public int getIdRoupaUtensilios() {
        return idRoupaUtensilios;
    }

    public void setIdRoupaUtensilios(int idRoupaUtensilios) {
        this.idRoupaUtensilios = idRoupaUtensilios;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public int getCodAluguel() {
        return codAluguel;
    }

    public void setCodAluguel(int codAluguel) {
        this.codAluguel = codAluguel;
    }
}
