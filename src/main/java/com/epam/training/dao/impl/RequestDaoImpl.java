package com.epam.training.dao.impl;

import com.epam.training.dao.AbstractDao;
import com.epam.training.dao.RequestDao;
import com.epam.training.model.RequestEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Repository("requestDao")
public class RequestDaoImpl extends AbstractDao<Integer, RequestEntity> implements RequestDao {

    public RequestEntity findById(int id) {
        return getByKey(id);
    }

    public void saveRequest(RequestEntity requestEntity) {
        persist(requestEntity);
    }

    public void deleteRequest(RequestEntity requestEntity) {
        Query query = getSession().createSQLQuery("delete from request where request_id = :request_id");
        query.setString("request_id", String.valueOf(requestEntity.getId()));
        query.executeUpdate();
    }
}
