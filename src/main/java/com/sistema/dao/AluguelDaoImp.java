package com.sistema.dao;

import com.sistema.model.Aluguel;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
