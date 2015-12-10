package com.epam.training.dataaccess.dao;

import com.epam.training.dataaccess.model.ClientEntity;
import org.joda.time.LocalDate;

import java.util.List;

/**
 * Created by Mao Shaco on 11/29/2015.
 */
public interface ClientDao {

    ClientEntity findById(int id);

    void saveClient(ClientEntity clientEntity);

    void deleteClientByName(String name);

    List<ClientEntity> findAllClients();

    ClientEntity findClientByName(String name);

    List<ClientEntity> findClientsByRoomNumbersOnDate(int roomNumberStarting, int roomNumberEnding, LocalDate interestedDate);

}
