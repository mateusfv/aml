package com.fiap.aml.dao;

import com.fiap.aml.entity.LanguageSpoken;

public interface LanguageSpokenDAO {

    LanguageSpoken findByName(String name);
}