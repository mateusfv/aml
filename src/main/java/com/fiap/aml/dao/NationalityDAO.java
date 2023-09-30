package com.fiap.aml.dao;

import com.fiap.aml.entity.Nationality;

public interface NationalityDAO {

    Nationality findByGentilic(String gentilic);

    Nationality findByAlpha2(String alpha2Code);
}