package com.epam.training.dataaccess.dao.impl;

import com.epam.training.dataaccess.dao.AbstractDao;
import com.epam.training.dataaccess.dao.BedDao;
import com.epam.training.dataaccess.model.BedEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Repository("bedDao")
public class BedDaoImpl extends AbstractDao<Integer, BedEntity> implements BedDao {
    public BedEntity findById(int id) {
        return getByKey(id);
    }

    public void saveBed(BedEntity bedEntity) {
        persist(bedEntity);
    }

    @SuppressWarnings("unchecked")
    public List<BedEntity> findAllBeds() {
        Criteria criteria = getSession().createCriteria(BedEntity.class);
        return (List<BedEntity>) criteria.list();
    }

    public BedEntity findBedByName(String bedName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("bed", bedName));
        return (BedEntity) criteria.uniqueResult();
    }
}
