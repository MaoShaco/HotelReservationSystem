package com.epam.training.services;

import com.epam.training.dataaccess.model.BedEntity;
import com.epam.training.dataaccess.model.RoomEntity;
import com.epam.training.dataaccess.model.SuiteEntity;
import org.joda.time.LocalDate;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
public interface RoomService {
    RoomEntity findById(int id);

    void saveRoom(RoomEntity room);

    void saveRoom(SuiteEntity suite);

    void saveBed(BedEntity bed);

    void updateRoom(RoomEntity room);

    void deleteRoomByNumber(int number);

    List<RoomEntity> findAllRooms();

    List<SuiteEntity> findAllSuities();

    List<BedEntity> findAllBeds();

    RoomEntity findRoomByNumber(int number);

    BedEntity findBedByName(String bedName);

    SuiteEntity findSuiteByName(String suiteName);

    boolean isRoomNumberUnique(Integer id, int number);

    boolean isBedUnique(Integer id, String bedName);

    boolean isSuiteUnique(Integer id, String suiteName);

    List<RoomEntity> findFreeRoomsOnDates(LocalDate entryDate, LocalDate outDate, String bed);

    List<RoomEntity> findFreeRoomsOnDates(LocalDate entryDate, LocalDate outDate, String bed, String suite);
}
