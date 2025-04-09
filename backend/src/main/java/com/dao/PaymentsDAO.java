package com.hotelhub.dao;

import com.hotelhub.model.Payments;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentsDAO {
    private final JdbcTemplate jdbcTemplate;

    public PaymentsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping result sets to Payments objects
    private RowMapper<Payments> paymentRowMapper = (rs, rowNum) -> new Payments(
            rs.getInt("payment_id"),
            rs.getInt("booking_id"),
            rs.getDouble("amount"),
            rs.getString("payment_method"),
            rs.getTimestamp("payment_date"),
            rs.getString("status")
    );

    // ✅ Add a new payment
    public int savePayment(Payments payment) {
        String sql = "INSERT INTO Payments (booking_id, amount, payment_method, payment_date, status) VALUES (?, ?, ?, ?, ?)";
        
        int result = jdbcTemplate.update(
            sql,
            payment.getBookingId(),
            payment.getAmount(),
            payment.getPaymentMethod(),
            payment.getPaymentDate(),
            payment.getStatus()
        );
        
        System.out.println("🧾 Insert result = " + result);
        return result;
    }
    
    

    // ✅ Get all payments
    public List<Payments> getAllPayments() {
        String sql = "SELECT * FROM Payments";
        return jdbcTemplate.query(sql, paymentRowMapper);
    }

    // ✅ Get a payment by ID
    public Payments getPaymentById(int paymentId) {
        String sql = "SELECT * FROM Payments WHERE payment_id = ?";
        return jdbcTemplate.queryForObject(sql, paymentRowMapper, paymentId);
    }

    // ✅ Update a payment
    public int updatePayment(Payments payment) {
        String sql = "UPDATE Payments SET booking_id = ?, amount = ?, payment_method = ?, status = ? WHERE payment_id = ?";
        return jdbcTemplate.update(sql, payment.getBookingId(), payment.getAmount(), payment.getPaymentMethod(), payment.getStatus(), payment.getPaymentId());
    }

    // ✅ Delete a payment
    public int deletePayment(int paymentId) {
        String sql = "DELETE FROM Payments WHERE payment_id = ?";
        return jdbcTemplate.update(sql, paymentId);
    }
}

