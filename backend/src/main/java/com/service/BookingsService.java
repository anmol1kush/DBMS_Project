package com.hotelhub.service;

import com.hotelhub.dao.BookingsDAO;
import com.hotelhub.model.Bookings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsService {
    private final BookingsDAO bookingsDAO;

    public BookingsService(BookingsDAO bookingsDAO) {
        this.bookingsDAO = bookingsDAO;
    }

    public int addBooking(Bookings booking) {
        return bookingsDAO.saveBooking(booking);  // ✅ Ye return kare bookingId
    }
    
    

    public List<Bookings> getAllBookings() {
        return bookingsDAO.getAllBookings();
    }

    public Bookings getBookingById(int bookingId) {
        return bookingsDAO.getBookingById(bookingId);
    }

    public int updateBooking(Bookings booking) {
        return bookingsDAO.updateBooking(booking);
    }

    public int deleteBooking(int bookingId) {
        return bookingsDAO.deleteBooking(bookingId);
    }
}

