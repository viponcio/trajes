package com.vitoria.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Aluguel implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codAluguel;

    @Column
    private String dataEvento;
    private String dataProva;
    private String dataRetirada;
    private String dataEntrega;
    private transient Long idCli;

    public Long getIdCli() {
        return idCli;
    }

    public void setIdCli(Long idCli) {
        this.idCli = idCli;
    }

    @ManyToOne//esta funcionando a fk
    @JoinColumn(name="idCli_FK")
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Aluguel(){

    }


    public Aluguel(Long codAluguel ,String dataEvento,String dataProva , String dataRetirada ,String dataEntrega) {
        this.codAluguel = codAluguel;
        this.dataEvento = dataEvento;
        this.dataProva = dataProva;

        this.dataRetirada = dataRetirada;
        this.dataEntrega = dataEntrega;
    }

    public Long getCodAluguel() {
        return codAluguel;
    }

    public void setCodAluguel(Long codAluguel) {
        this.codAluguel = codAluguel;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDataProva() {
        return dataProva;
    }

    public void setDataProva(String dataProva) {
        this.dataProva = dataProva;
    }

    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }


}
