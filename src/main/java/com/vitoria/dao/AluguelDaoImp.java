package com.vitoria.dao;

import com.vitoria.model.Aluguel;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AluguelDaoImp {

    public boolean salvar(Aluguel aluguel){
        String sql="INSERT INTO aluguel (codAluguel,dataEntrega,dataEvento,dataProva,dataRetirada,idCli) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;

        try{
            stmt.setLong(1, aluguel.getCodAluguel());
            stmt.setString(2,aluguel.getDataEntrega());
            stmt.setString(3 ,aluguel.getDataEvento());
            stmt.setString(4,aluguel.getDataProva());
            stmt.setString(5,aluguel.getDataRetirada());
            stmt.setLong(7 ,aluguel.getCliente().getIdCli());
            stmt.executeUpdate();
            return true;
        }catch (SQLException ex){
            System.out.println("erro:"+ex);
        }
        return false;
    }
}
