package com.epam.training.services.impl;

import com.epam.training.dataaccess.dao.BedDao;
import com.epam.training.dataaccess.dao.RoomDao;
import com.epam.training.dataaccess.dao.SuiteDao;
import com.epam.training.dataaccess.model.BedEntity;
import com.epam.training.dataaccess.model.RoomEntity;
import com.epam.training.dataaccess.model.SuiteEntity;
import com.epam.training.services.RoomService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Service("roomService")
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao dao;

    @Autowired
    private SuiteDao suiteDao;

    @Autowired
    private BedDao bedDao;


    public RoomEntity findById(int id) {
        return dao.findById(id);
    }

    public void saveRoom(RoomEntity room) {
        dao.saveRoom(room);
    }

    public void saveRoom(SuiteEntity suite) {
        suiteDao.saveSuite(suite);
    }

    public void saveBed(BedEntity bed) {
        bedDao.saveBed(bed);
    }

    public void updateRoom(RoomEntity room) {
        RoomEntity entity = dao.findById(room.getId());
        if (entity != null) {
            entity.setCost(room.getCost());
            entity.setNumber(room.getNumber());
            entity.setBedByBedId(room.getBedByBedId());
            entity.setSuiteBySuiteId(room.getSuiteBySuiteId());
        }
    }

    public void deleteRoomByNumber(int number) {
        dao.deleteRoomByNumber(number);
    }

    public List<RoomEntity> findAllRooms() {
        return dao.findAllRooms();
    }

    public List<SuiteEntity> findAllSuities() {
        return suiteDao.findAllSuities();
    }

    public List<BedEntity> findAllBeds() {
        return bedDao.findAllBeds();
    }

    public RoomEntity findRoomByNumber(int number) {
        return dao.findRoomByNumber(number);
    }

    public BedEntity findBedByName(String bedName) {
        return bedDao.findBedByName(bedName);
    }

    public SuiteEntity findSuiteByName(String suiteName) {
        return suiteDao.findSuiteByName(suiteName);
    }

    public boolean isRoomNumberUnique(Integer id, int number) {
        RoomEntity room = findRoomByNumber(number);
        return (room == null || ((id != null) && (room.getId() == id)));

    }

    public boolean isBedUnique(Integer id, String bedName) {
        BedEntity bed = findBedByName(bedName);
        return (bed == null || ((id != null) && (bed.getId() == id)));
    }

    public boolean isSuiteUnique(Integer id, String suiteName) {
        SuiteEntity suite = findSuiteByName(suiteName);
        return (suite == null || ((id != null) && (suite.getId() == id)));
    }

    public List<RoomEntity> findFreeRoomsOnDates(LocalDate entryDate, LocalDate outDate, String bed) {
        return dao.findFreeRoomsBedsDates(entryDate, outDate, bed);
    }

    public List<RoomEntity> findFreeRoomsOnDates(LocalDate entryDate, LocalDate outDate, String bed, String suite) {
        return dao.findFreeRoomsBedsSuiteDates(entryDate, outDate, bed, suite);
    }
}
