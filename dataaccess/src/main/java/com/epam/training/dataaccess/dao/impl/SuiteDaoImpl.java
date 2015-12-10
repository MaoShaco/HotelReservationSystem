package com.epam.training.dataaccess.dao.impl;


import com.epam.training.dataaccess.dao.AbstractDao;
import com.epam.training.dataaccess.dao.SuiteDao;
import com.epam.training.dataaccess.model.SuiteEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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

    public SuiteEntity findSuiteByName(String suiteName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("suite", suiteName));
        return (SuiteEntity) criteria.uniqueResult();
    }
}
