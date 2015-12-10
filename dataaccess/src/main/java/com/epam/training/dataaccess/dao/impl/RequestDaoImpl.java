package com.epam.training.dataaccess.dao.impl;

import com.epam.training.dataaccess.dao.AbstractDao;
import com.epam.training.dataaccess.dao.RequestDao;
import com.epam.training.dataaccess.model.RequestEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<RequestEntity> findRequestsByClientName(String clientName) {
        Criteria criteria = getSession().createCriteria(RequestEntity.class, "request")
                .createCriteria("request.clientByClientId", "client")
                .add(Restrictions.eq("client", clientName));
        return (List<RequestEntity>) criteria.list();
    }
}
