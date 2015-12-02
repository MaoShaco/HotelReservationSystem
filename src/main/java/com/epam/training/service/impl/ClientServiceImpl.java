package com.epam.training.service.impl;

import com.epam.training.dao.ClientDao;
import com.epam.training.model.Client;
import com.epam.training.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao dao;

    public Client findById(int id) {
        return dao.findById(id);
    }

    public void saveClient(Client client) {
        dao.saveClient(client);
    }

    public void updateClient(Client client) {
        Client entity = dao.findById(client.getId());
        if (entity != null) {
            entity.setName(client.getName());
            entity.setPassword(client.getPassword());
            entity.setCardNumber(client.getCardNumber());
            entity.setEmail(client.getEmail());
        }
    }

    public void deleteClientByName(String name) {
        dao.deleteClientByName(name);
    }

    public List<Client> findAllClients() {
        return dao.findAllClients();
    }

    public Client findClientByName(String name) {
        return dao.findClientByName(name);
    }

    public boolean isClientNameUnique(Integer id, String name) {
        Client client = findClientByName(name);
        return (client == null || ((id != null) && (client.getId() == id)));
    }
}
