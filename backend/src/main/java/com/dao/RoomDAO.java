package com.hotelhub.dao;

import com.hotelhub.model.Room;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RoomDAO {

    private final JdbcTemplate jdbcTemplate;

    public RoomDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 🔹 Fetch all rooms
    public List<Room> getAllRooms() {
        String sql = "SELECT * FROM rooms";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Room(
                rs.getLong("room_id"),             // 🔄 Updated column names
                rs.getString("room_number"),
                rs.getString("room_type"),        // ENUM as String
                rs.getDouble("price_per_night"),
                rs.getString("status"),          // ENUM as String
                rs.getInt("max_capacity")
        ));
    }

    // 🔹 Fetch a room by ID
    public Room getRoomById(Long roomId) {
        String sql = "SELECT * FROM rooms WHERE room_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{roomId}, (rs, rowNum) -> new Room(
                rs.getLong("room_id"),
                rs.getString("room_number"),
                rs.getString("room_type"),
                rs.getDouble("price_per_night"),
                rs.getString("status"),
                rs.getInt("max_capacity")
        ));
    }

    // 🔹 Add a room
    public Room addRoom(Room room) {
        String sql = "INSERT INTO rooms (room_number, room_type, price_per_night, status, max_capacity) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, room.getRoomNumber(), room.getRoomType(), room.getPricePerNight(), room.getStatus(), room.getMaxCapacity());
        return room;
    }

    // 🔹 Update a room
    public void updateRoom(Long roomId, Room room) {
        String sql = "UPDATE rooms SET room_number = ?, room_type = ?, price_per_night = ?, status = ?, max_capacity = ? WHERE room_id = ?";
        jdbcTemplate.update(sql, room.getRoomNumber(), room.getRoomType(), room.getPricePerNight(), room.getStatus(), room.getMaxCapacity(), roomId);
    }

    // 🔹 Delete a room
    public void deleteRoom(Long roomId) {
        String sql = "DELETE FROM rooms WHERE room_id = ?";
        jdbcTemplate.update(sql, roomId);
    }
}
