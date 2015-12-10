package com.epam.training.services.impl;

import com.epam.training.dataaccess.dao.BookingDao;
import com.epam.training.dataaccess.model.BookingEntity;
import com.epam.training.dataaccess.model.RequestEntity;
import com.epam.training.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Service("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    public BookingEntity findBookingById(int id) {
        return bookingDao.findById(id);
    }

    public List<BookingEntity> findAllBookings() {
        return bookingDao.findAllBookings();
    }

    public void deleteUsingRequest(RequestEntity request) {
        bookingDao.deleteBookingByRequest(request);
    }

    public void saveNewBooking(BookingEntity booking) {
        bookingDao.saveBooking(booking);
    }
        /*BookingEntity bookingEntity = new BookingEntity();

        RoomEntity roomOnBooking = roomService.findFreeRoomsOnDates(
                request.getCheckIn(),
                request.getCheckOut(),
                request.getBedByBedId().getBed(),
                request.getSuiteBySuiteId().getSuite()).get(0);

        Integer bookingExpense = roomOnBooking.getCost() * Days.daysBetween(request.getCheckOut(), request.getCheckIn()).getDays();

        bookingEntity.setRequestByRequestId(request);
        bookingEntity.setRoomByRoomId(roomOnBooking);
        bookingEntity.setExpense(bookingExpense);*/
}
