package com.epam.training.dao;

import com.epam.training.model.SuiteEntity;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
public interface SuiteDao {
    SuiteEntity findById(int id);

    void saveSuite(SuiteEntity suiteEntity);

    List<SuiteEntity> findAllSuities();

    SuiteEntity findSuiteByName(String suiteName);
}
