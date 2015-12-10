package com.epam.training.dataaccess.dao;


import com.epam.training.dataaccess.model.RoomEntity;
import org.joda.time.LocalDate;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
public interface RoomDao {
    RoomEntity findById(int id);

    void saveRoom(RoomEntity room);

    void deleteRoomByNumber(int number);

    List<RoomEntity> findAllRooms();

    RoomEntity findRoomByNumber(int number);

    List<RoomEntity> findFreeRoomsBedsDates(LocalDate entryDate, LocalDate outDate, String bed);

    List<RoomEntity> findFreeRoomsBedsSuiteDates(LocalDate entryDate, LocalDate outDate, String bed, String suite);
}
