package com.sistema.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Aluguel implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codAluguel;

    @Column
    private float preco;
    private Date dataEvento;
    private Date dataProva;
    private Date dataRetirada;
    private Date dataEntrega;
    private int idFunc;

    public Aluguel(){

    }

    public Long getCodAluguel() {
        return codAluguel;
    }

    public void setCodAluguel(Long codAluguel) {
        this.codAluguel = codAluguel;
    }

    public Aluguel(Long codAluguel, float preco, Date dataEvento, Date dataProva, Date dataRetirada, Date dataEntrega, int idFunc) {
        this.codAluguel = codAluguel;
        this.preco = preco;
        this.dataEvento = dataEvento;
        this.dataProva = dataProva;
        this.dataRetirada = dataRetirada;
        this.dataEntrega = dataEntrega;
        this.idFunc = idFunc;
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

}
