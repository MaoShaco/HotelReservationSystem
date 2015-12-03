package com.epam.training.dao;

import com.epam.training.model.BedEntity;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
public interface BedDao {
    BedEntity findById(int id);

    void saveBed(BedEntity bedEntity);

    List<BedEntity> findAllBeds();

    BedEntity findBedByName(String bedName);
}
