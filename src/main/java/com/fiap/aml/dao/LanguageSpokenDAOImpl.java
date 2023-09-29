package com.fiap.aml.dao;

import com.fiap.aml.entity.LanguageSpoken;
import com.fiap.aml.entity.Nationality;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LanguageSpokenDAOImpl implements LanguageSpokenDAO {

    private EntityManager entityManager;

    @Autowired
    public LanguageSpokenDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public LanguageSpoken findByName(String name) {

        // Create query
        TypedQuery<LanguageSpoken> query = entityManager.createQuery(
                "SELECT l FROM LanguageSpoken l WHERE l.language = :name",
                LanguageSpoken.class
        );
        query.setParameter("name", name);

        // Search the language
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}