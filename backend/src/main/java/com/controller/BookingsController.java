package com.hotelhub.controller;
import java.util.Map;


import com.hotelhub.model.Bookings;
import com.hotelhub.service.BookingsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingsController {
    private final BookingsService bookingsService;

    public BookingsController(BookingsService bookingsService) {
        this.bookingsService = bookingsService;
    }

    // ✅ Get all bookings
    @GetMapping
    public List<Bookings> getAllBookings() {
        return bookingsService.getAllBookings();
    }

    // ✅ Get a booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<Bookings> getBookingById(@PathVariable int id) {
        Bookings booking = bookingsService.getBookingById(id);
        return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
    }

    // ✅ Add a new booking
    @PostMapping
    public ResponseEntity<?> addBooking(@RequestBody Bookings booking) {
        int bookingId = bookingsService.addBooking(booking);  // Service se ID aa rahi
        return ResponseEntity.ok().body(Map.of("bookingId", bookingId)); // ✅ return JSON
    }
    

    


    // ✅ Update booking details
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBooking(@PathVariable int id, @RequestBody Bookings booking) {
        booking.setBookingId(id);
        int result = bookingsService.updateBooking(booking);
        return result > 0 ? ResponseEntity.ok("Booking updated successfully") : ResponseEntity.notFound().build();
    }

    // ✅ Delete a booking
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id) {
        int result = bookingsService.deleteBooking(id);
        return result > 0 ? ResponseEntity.ok("Booking deleted successfully") : ResponseEntity.notFound().build();
    }
}

