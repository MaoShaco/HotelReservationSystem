package com.epam.training.service;

import com.epam.training.model.BookingEntity;
import com.epam.training.model.RequestEntity;

import java.util.List;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
public interface BookingService {
    BookingEntity findBookingById(int id);

    List<BookingEntity> findAllBookings();

    void deleteUsingRequest(RequestEntity request);

    void saveNewBooking(BookingEntity booking);
}
