package com.epam.training.dao;

import com.epam.training.model.RequestEntity;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
public interface RequestDao {
    RequestEntity findById(int id);

    void saveRequest(RequestEntity requestEntity);

    void deleteRequest(RequestEntity requestEntity);

    List<RequestEntity> findRequestsByClientName(String clientName);
}
