package com.epam.training.service;

import com.epam.training.model.BedEntity;
import com.epam.training.model.RequestEntity;
import com.epam.training.model.SuiteEntity;

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
