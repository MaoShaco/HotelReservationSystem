package com.epam.training.services.impl;

import com.epam.training.dataaccess.dao.ClientDao;
import com.epam.training.dataaccess.model.ClientEntity;
import com.epam.training.services.ClientService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao dao;

    public ClientEntity findById(int id) {
        return dao.findById(id);
    }

    public void saveClient(ClientEntity clientEntity) {
        dao.saveClient(clientEntity);
    }

    public void updateClient(ClientEntity clientEntity) {
        ClientEntity entity = dao.findById(clientEntity.getId());
        if (entity != null) {
            entity.setName(clientEntity.getName());
            entity.setPassword(clientEntity.getPassword());
            entity.setCardNumber(clientEntity.getCardNumber());
            entity.setEmail(clientEntity.getEmail());
        }
    }

    public void deleteClientByName(String name) {
        dao.deleteClientByName(name);
    }

    public List<ClientEntity> findAllClients() {
        return dao.findAllClients();
    }

    public ClientEntity findClientByName(String name) {
        return dao.findClientByName(name);
    }

    public boolean isClientNameUnique(Integer id, String name) {
        ClientEntity clientEntity = findClientByName(name);
        return (clientEntity == null || ((id != null) && (clientEntity.getId() == id)));

    }

    public List<ClientEntity> findClientsByRoomNumberOnDate(int roomNumber, LocalDate interestedDate) {
        return findClientsByRoomNumbersOnDate(roomNumber, roomNumber, interestedDate);
    }

    public List<ClientEntity> findClientsByRoomNumbersOnDate(int roomNumberStarting, int roomNumberEnding, LocalDate interestedDate) {
        return dao.findClientsByRoomNumbersOnDate(roomNumberStarting, roomNumberEnding, interestedDate);
    }
}
