package com.sistema.dao;

import com.sistema.model.Cliente;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
@Transactional
public class ClienteDaoImp implements ClienteDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> getByNomeCli(String nomeCli) {//jpql serve para busca
        String jpql= "select c from Cliente c where lower(c.nomeCli)  like :nomeCli";
        TypedQuery<Cliente> query= entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nomeCli","%"+nomeCli.toLowerCase()+"%");
        return query.getResultList();
    }
}
