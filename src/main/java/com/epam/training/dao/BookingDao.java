package com.epam.training.dao;

import com.epam.training.model.BookingEntity;
import com.epam.training.model.RequestEntity;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
public interface BookingDao {
    BookingEntity findById(int id);

    void saveBooking(BookingEntity bookingEntity);

    void deleteBookingByRequest(RequestEntity requestEntity);

    List<BookingEntity> findAllBookings();
}
