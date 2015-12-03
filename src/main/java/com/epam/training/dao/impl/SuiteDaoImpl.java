package com.epam.training.dao.impl;

import com.epam.training.dao.AbstractDao;
import com.epam.training.dao.SuiteDao;
import com.epam.training.model.SuiteEntity;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Repository("suiteDao")
public class SuiteDaoImpl extends AbstractDao<Integer, SuiteEntity> implements SuiteDao {
    public SuiteEntity findById(int id) {
        return getByKey(id);
    }

    public void saveSuite(SuiteEntity suiteEntity) {
        persist(suiteEntity);
    }

    @SuppressWarnings("unchecked")
    public List<SuiteEntity> findAllSuities() {
        Criteria criteria = getSession().createCriteria(SuiteEntity.class);
        return (List<SuiteEntity>) criteria.list();
    }
}
