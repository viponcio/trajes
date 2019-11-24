package com.sistema.dao;

import com.sistema.model.RoupaUtensilios;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
}
