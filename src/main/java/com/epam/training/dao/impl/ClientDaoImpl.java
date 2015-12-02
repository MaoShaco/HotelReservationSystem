package com.epam.training.dao.impl;

import com.epam.training.dao.AbstractDao;
import com.epam.training.dao.ClientDao;
import com.epam.training.model.Client;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

    public Client findById(int id) {
        return getByKey(id);
    }

    public void saveClient(Client client) {
        persist(client);
    }

    public void deleteClientByName(String name) {
        Query query = getSession().createSQLQuery("delete from clients where name = :name");
        query.setString("name", name);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Client> findAllClients() {
        Criteria criteria = getSession().createCriteria(Client.class);
        return (List<Client>) criteria.list();
    }

    public Client findClientByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Client) criteria.uniqueResult();
    }
}
