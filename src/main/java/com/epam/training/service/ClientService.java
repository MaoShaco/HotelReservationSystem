package com.epam.training.service;

import com.epam.training.model.ClientEntity;

import java.util.List;

public interface ClientService {

    ClientEntity findById(int id);

    void saveClient(ClientEntity clientEntity);

    void updateClient(ClientEntity clientEntity);

    void deleteClientByName(String name);

    List<ClientEntity> findAllClients();

    ClientEntity findClientByName(String name);

    boolean isClientNameUnique(Integer id, String name);
}
