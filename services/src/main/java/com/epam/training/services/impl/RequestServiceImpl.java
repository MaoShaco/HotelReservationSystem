package com.epam.training.services.impl;

import com.epam.training.dataaccess.dao.BedDao;
import com.epam.training.dataaccess.dao.RequestDao;
import com.epam.training.dataaccess.dao.SuiteDao;
import com.epam.training.dataaccess.model.BedEntity;
import com.epam.training.dataaccess.model.RequestEntity;
import com.epam.training.dataaccess.model.SuiteEntity;
import com.epam.training.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */

@Service("requestServcice")
@Transactional
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDao dao;

    @Autowired
    private SuiteDao suiteDao;

    @Autowired
    private BedDao bedDao;

    public RequestEntity findById(int id) {
        return dao.findById(id);
    }

    public void saveRequest(RequestEntity request) {
        dao.saveRequest(request);
    }

    public void deleteRequest(RequestEntity request) {
        dao.deleteRequest(request);
    }

    public List<RequestEntity> findRequestsByClientName(String clientName) {
        return dao.findRequestsByClientName(clientName);
    }

    public List<SuiteEntity> findAllSuities() {
        return suiteDao.findAllSuities();
    }

    public List<BedEntity> findAllBeds() {
        return bedDao.findAllBeds();
    }
}
