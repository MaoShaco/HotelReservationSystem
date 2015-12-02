package com.epam.training.service;

import com.epam.training.model.Client;

import java.util.List;

public interface ClientService {

    Client findById(int id);

    void saveClient(Client client);

    void updateClient(Client client);

    void deleteClientByName(String name);

    List<Client> findAllClients();

    Client findClientByName(String name);

    boolean isClientNameUnique(Integer id, String name);
}
