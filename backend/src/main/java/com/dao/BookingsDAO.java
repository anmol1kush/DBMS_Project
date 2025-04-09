package com.hotelhub.dao;

import com.hotelhub.model.Bookings;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;



import java.util.List;

@Repository
public class BookingsDAO {
    private final JdbcTemplate jdbcTemplate;

    public BookingsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping result sets to Bookings objects
    private RowMapper<Bookings> bookingRowMapper = (rs, rowNum) -> new Bookings(
            rs.getInt("booking_id"),
            rs.getInt("guest_id"),
            rs.getInt("room_id"),
            rs.getDate("check_in_date"),
            rs.getDate("check_out_date"),
            rs.getDouble("total_price")

           
    );

    // ✅ Add a new booking
    public int saveBooking(Bookings booking) {
        String sql = "INSERT INTO Bookings (guest_id, room_id, check_in_date, check_out_date, total_price) VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
    
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, booking.getGuestId());
            ps.setInt(2, booking.getRoomId());
            ps.setDate(3, booking.getCheckInDate());
            ps.setDate(4, booking.getCheckOutDate());
            ps.setDouble(5, booking.getTotalPrice());
            return ps;
        }, keyHolder);
    
        return keyHolder.getKey().intValue();  // This returns the generated booking_id
    }
    
    

    // ✅ Get all bookings
    public List<Bookings> getAllBookings() {
        String sql = "SELECT * FROM Bookings";
        return jdbcTemplate.query(sql, bookingRowMapper);
    }

    // ✅ Get a booking by ID
    public Bookings getBookingById(int bookingId) {
        String sql = "SELECT * FROM Bookings WHERE booking_id = ?";
        return jdbcTemplate.queryForObject(sql, bookingRowMapper, bookingId);
    }

    // ✅ Update a booking
    public int updateBooking(Bookings booking) {
        String sql = "UPDATE Bookings SET guest_id = ?, room_id = ?, check_in_date = ?, check_out_date = ?, total_price = ? WHERE booking_id = ?";
        return jdbcTemplate.update(sql, booking.getGuestId(), booking.getRoomId(), booking.getCheckInDate(), booking.getCheckOutDate(), booking.getTotalPrice(),booking.getBookingId());
    }

    // ✅ Delete a booking
    public int deleteBooking(int bookingId) {
        String sql = "DELETE FROM Bookings WHERE booking_id = ?";
        return jdbcTemplate.update(sql, bookingId);
    }
}

