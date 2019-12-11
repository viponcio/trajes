package com.vitoria.dao;

import com.vitoria.model.RoupaUtensilios;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
@Repository
@Transactional
public class RoupaUtensiliosDaoImp implements RoupaUtensiliosDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional(readOnly = true)
    @Override
    public List<RoupaUtensilios> getByCor(String cor) {
        String jpql="select ru from RoupaUtensilios ru where lower(ru.cor) like :cor";
        TypedQuery<RoupaUtensilios> query = entityManager.createQuery(jpql,RoupaUtensilios.class);
        query.setParameter("cor",cor.toLowerCase());
        return query.getResultList();
    }


    @Transactional(readOnly = true)
    @Override
    public boolean alterar(RoupaUtensilios ru){
        System.out.println("entrou antes do conection");
        try(Connection conn = new ConexaoBD().getConexao()){
            String query="update roupa_utensilios set cor=? ,preco_roupa_utensilio = ? ,tamanho = ? ,cod_tipo_roupa = ? " +
                    " where cod_roupa_utensilios = ?;";
            System.out.println("entrou dentro do try");
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, ru.getCor());
            pre.setFloat(2, ru.getPrecoRoupaUtensilio());
            pre.setString(3, ru.getTamanho());
            pre.setLong(4, ru.getCodTipoRoupa());
            pre.setLong(5,ru.getCodRoupaUtensilios());
            if (pre.executeUpdate() > 0) {
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;



    }

}
