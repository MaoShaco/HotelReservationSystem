package com.epam.training.services;

import com.epam.training.dataaccess.model.ClientEntity;
import org.joda.time.LocalDate;

import java.util.List;

public interface ClientService {

    ClientEntity findById(int id);

    void saveClient(ClientEntity clientEntity);

    void updateClient(ClientEntity clientEntity);

    void deleteClientByName(String name);

    List<ClientEntity> findAllClients();

    ClientEntity findClientByName(String name);

    boolean isClientNameUnique(Integer id, String name);

    List<ClientEntity> findClientsByRoomNumberOnDate(int roomNumber, LocalDate interestedDate);

    List<ClientEntity> findClientsByRoomNumbersOnDate(int roomNumberStarting, int roomNumberEnding, LocalDate interestedDate);

}
