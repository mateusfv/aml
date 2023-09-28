package com.fiap.aml.dao;

import com.fiap.aml.entity.Wanted;

import java.util.List;

public interface WantedDAO {

    List<Wanted> findAll();

    Wanted findById(int theId);

    Wanted save(Wanted theWanted);

    void deleteById(int theId);
}