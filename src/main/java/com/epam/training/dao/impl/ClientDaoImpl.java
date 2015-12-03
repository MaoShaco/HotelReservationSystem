package com.epam.training.dao.impl;

import com.epam.training.dao.AbstractDao;
import com.epam.training.dao.ClientDao;
import com.epam.training.model.ClientEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, ClientEntity> implements ClientDao {

    public ClientEntity findById(int id) {
        return getByKey(id);
    }

    public void saveClient(ClientEntity clientEntity) {
        persist(clientEntity);
    }

    public void deleteClientByName(String name) {
        Query query = getSession().createSQLQuery("delete from client where name = :name");
        query.setString("name", name);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<ClientEntity> findAllClients() {
        Criteria criteria = getSession().createCriteria(ClientEntity.class);
        return (List<ClientEntity>) criteria.list();
    }

    public ClientEntity findClientByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (ClientEntity) criteria.uniqueResult();
    }

    public List<ClientEntity> findClientsByRoomNumbersOnDate(int roomNumberStarting, int roomNumberEnding, LocalDate interestedDate) {
        Criteria criteria = getSession().createCriteria(ClientEntity.class, "client")
                .createCriteria("client.requestsById", "requests")
                .createCriteria("requests.bookingsById", "booking")
                .createCriteria("booking.roomByRoomId", "room")
                .add(Restrictions.between("room.number", roomNumberStarting, roomNumberEnding))
                .add(Restrictions.ge("requests.checkOut", interestedDate))
                .add(Restrictions.le("requests.checkIn", interestedDate));

        return (List<ClientEntity>) criteria.list();
    }
}
