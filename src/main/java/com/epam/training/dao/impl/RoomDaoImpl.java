package com.epam.training.dao.impl;

import com.epam.training.dao.AbstractDao;
import com.epam.training.dao.RoomDao;
import com.epam.training.model.RoomEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Repository("roomDao")
public class RoomDaoImpl extends AbstractDao<Integer, RoomEntity> implements RoomDao {
    public RoomEntity findById(int id) {
        return getByKey(id);
    }

    public void saveRoom(RoomEntity room) {
        persist(room);
    }

    public void deleteRoomByNumber(int number) {
        Query query = getSession().createSQLQuery("delete from room where number = :number");
        query.setString("number", String.valueOf(number));
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<RoomEntity> findAllRooms() {
        Criteria criteria = getSession().createCriteria(RoomEntity.class);
        return (List<RoomEntity>) criteria.list();
    }

    public RoomEntity findRoomByNumber(int number) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("number", number));
        return (RoomEntity) criteria.uniqueResult();
    }

    public List<RoomEntity> findFreeRoomsBedsDates(LocalDate entryDate, LocalDate outDate, String bed) {
        Criteria criteria = getSession().createCriteria(RoomEntity.class, "room")
                .add(Restrictions.eq("room.bedByBedId", bed))
                .createAlias("bookingsById", "bookings", JoinType.LEFT_OUTER_JOIN)
                .createAlias("bookings.requestByRequestId", "request")
                .add(Restrictions.or(
                        Restrictions.isEmpty("bookingsById"),
                        Restrictions.le("request.checkOut", entryDate),
                        Restrictions.ge("request.checkIn", outDate)));

        return (List<RoomEntity>) criteria.list();
    }

    public List<RoomEntity> findFreeRoomsBedsSuiteDates(LocalDate entryDate, LocalDate outDate, String bed, String suite) {
        Criteria criteria = getSession().createCriteria(RoomEntity.class, "room")
                .add(Restrictions.eq("room.suiteBySuiteId", suite))
                .add(Restrictions.eq("room.bedByBedId", bed))
                .createAlias("bookingsById", "bookings", JoinType.LEFT_OUTER_JOIN)
                .createAlias("bookings.requestByRequestId", "request", JoinType.LEFT_OUTER_JOIN)
                .add(Restrictions.or(
                        Restrictions.isEmpty("bookingsById"),
                        Restrictions.le("request.checkOut", entryDate),
                        Restrictions.ge("request.checkIn", outDate)));

        return (List<RoomEntity>) criteria.list();
    }
}
