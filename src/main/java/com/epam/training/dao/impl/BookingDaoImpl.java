package com.epam.training.dao.impl;

import com.epam.training.dao.AbstractDao;
import com.epam.training.dao.BookingDao;
import com.epam.training.model.BookingEntity;
import com.epam.training.model.RequestEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Repository("bookingDao")
public class BookingDaoImpl extends AbstractDao<Integer,BookingEntity> implements BookingDao {

    public BookingEntity findById(int id) {
        return getByKey(id);
    }

    public void saveBooking(BookingEntity bookingEntity) {
        persist(bookingEntity);
    }

    public void deleteBookingByRequest(RequestEntity requestEntity) {
        Query query = getSession().createSQLQuery("delete from booking where request_id = :request_id");
        query.setString("request_id", String.valueOf(requestEntity.getId()));
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<BookingEntity> findAllBookings() {
        Criteria criteria = getSession().createCriteria(BookingEntity.class);
        return (List<BookingEntity>) criteria.list();
    }
}
