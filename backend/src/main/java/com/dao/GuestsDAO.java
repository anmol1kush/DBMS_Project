package com.hotelhub.dao;

import com.hotelhub.model.Guests;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import java.sql.PreparedStatement;


import java.util.List;

@Repository
public class GuestsDAO {
    private final JdbcTemplate jdbcTemplate;

    public GuestsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping result sets to Guest objects
    private RowMapper<Guests> guestRowMapper = (rs, rowNum) -> new Guests(
            rs.getInt("guest_id"),
            rs.getInt("user_id"),
            rs.getString("address"),
            rs.getString("city"),
            rs.getString("country"),
            rs.getString("id_proof_type"),
            rs.getString("id_proof_number")
    );

    // ✅ Add a new guest
  

public Guests saveGuest(Guests guest) {
    String sql = "INSERT INTO Guests (user_id, address, city, country, id_proof_type, id_proof_number) VALUES (?, ?, ?, ?, ?, ?)";

    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(connection -> {
        PreparedStatement ps = connection.prepareStatement(sql, new String[]{"guest_id"});
        ps.setInt(1, guest.getUserId());
        ps.setString(2, guest.getAddress());
        ps.setString(3, guest.getCity());
        ps.setString(4, guest.getCountry());
        ps.setString(5, guest.getIdProofType());
        ps.setString(6, guest.getIdProofNumber());
        return ps;
    }, keyHolder);

    if (keyHolder.getKey() != null) {
        guest.setGuestId(keyHolder.getKey().intValue()); // ✅ Set the auto-generated ID
        return guest; // ✅ Return full guest object
    } else {
        return null;
    }
}


    // ✅ Get all guests
    public List<Guests> getAllGuests() {
        String sql = "SELECT * FROM Guests";
        return jdbcTemplate.query(sql, guestRowMapper);
    }

    // ✅ Get a guest by ID
    public Guests getGuestById(int guestId) {
        String sql = "SELECT * FROM Guests WHERE guest_id = ?";
        return jdbcTemplate.queryForObject(sql, guestRowMapper, guestId);
    }

    // ✅ Update a guest
    public int updateGuest(Guests guest) {
        String sql = "UPDATE Guests SET address = ?, city = ?, country = ?, id_proof_type = ?, id_proof_number = ? WHERE guest_id = ?";
        return jdbcTemplate.update(sql, guest.getAddress(), guest.getCity(), guest.getCountry(), guest.getIdProofType(), guest.getIdProofNumber(), guest.getGuestId());
    }

    // ✅ Delete a guest
    public int deleteGuest(int guestId) {
        String sql = "DELETE FROM Guests WHERE guest_id = ?";
        return jdbcTemplate.update(sql, guestId);
    }
}

