package com.epam.training.dao;

import com.epam.training.model.Client;

import java.util.List;

/**
 * Created by Mao Shaco on 11/29/2015.
 */
public interface ClientDao {

    Client findById(int id);

    void saveClient(Client client);

    void deleteClientByName(String name);

    List<Client> findAllClients();

    Client findClientByName(String name);
}
