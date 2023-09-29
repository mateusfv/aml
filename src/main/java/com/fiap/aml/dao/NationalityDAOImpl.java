package com.fiap.aml.dao;

import com.fiap.aml.entity.Nationality;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NationalityDAOImpl implements NationalityDAO {

    private EntityManager entityManager;

    @Autowired
    public NationalityDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public Nationality findByGentilic(String gentilic) {
        // Create the query and set its parameter
        TypedQuery<Nationality> query = entityManager.createQuery(
                "SELECT n FROM Nationality n WHERE n.gentilic = :gentilic",
                Nationality.class
        );
        query.setParameter("gentilic", gentilic);

        // Search the nationality
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}