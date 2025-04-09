package com.hotelhub.service;

import com.hotelhub.dao.RoomDAO;
import com.hotelhub.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomDAO roomDAO;

    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    // ✅ Get all rooms (Fixed: Using getAllRooms instead of findAll)
    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    // ✅ Add a room (Fixed: Using addRoom instead of save)
    public Room addRoom(Room room) {
        return roomDAO.addRoom(room);
    }

    // ✅ Get a room by ID (Fixed: Using getRoomById instead of findById)
    public Room getRoomById(Long roomId) {
        return roomDAO.getRoomById(roomId);
    }

    // ✅ Update a room (Fixed: Removed setId, using updateRoom)
    public void updateRoom(Long roomId, Room room) {
        roomDAO.updateRoom(roomId, room);
    }

    // ✅ Delete a room (Fixed: Using deleteRoom instead of deleteById)
    public void deleteRoom(Long roomId) {
        roomDAO.deleteRoom(roomId);
    }
}
