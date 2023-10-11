package com.fiap.aml.dao;

import com.fiap.aml.entity.Wanted;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WantedDAOImpl implements WantedDAO {

    private EntityManager entityManager;

    @Autowired
    public WantedDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Wanted> findAll() {

        TypedQuery<Wanted> query = entityManager.createQuery("from Wanted", Wanted.class);
        List<Wanted> wanteds = query.getResultList();
        return wanteds;
    }

    @Override
    public Wanted findById(int theId) {
        Wanted theWanted = entityManager.find(Wanted.class, theId);
        return theWanted;
    }

    @Override
    public List<Wanted> findByPartialName(String partialName) {

        TypedQuery<Wanted> query = entityManager.createQuery("SELECT w FROM Wanted w WHERE w.nameTitle LIKE :partialName", Wanted.class);
        query.setParameter("partialName", "%" + partialName.toUpperCase() + "%");
        List<Wanted> wanteds = query.getResultList();
        return wanteds;
    }

    @Override
    @Transactional
    public Wanted save(Wanted theWanted) {
        Wanted dbWanted = entityManager.merge(theWanted);
        return dbWanted;
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Wanted theWanted = entityManager.find(Wanted.class, theId);
        entityManager.remove(theWanted);
    }
}