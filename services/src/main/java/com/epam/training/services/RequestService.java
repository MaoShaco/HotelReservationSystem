package com.epam.training.services;

import com.epam.training.dataaccess.model.BedEntity;
import com.epam.training.dataaccess.model.RequestEntity;
import com.epam.training.dataaccess.model.SuiteEntity;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
public interface RequestService {
    RequestEntity findById(int id);

    void saveRequest(RequestEntity request);

    void deleteRequest(RequestEntity request);

    List<RequestEntity> findRequestsByClientName(String clientName);

    List<SuiteEntity> findAllSuities();

    List<BedEntity> findAllBeds();
}
