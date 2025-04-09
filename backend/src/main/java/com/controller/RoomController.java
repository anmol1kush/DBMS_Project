package com.hotelhub.controller;

import com.hotelhub.model.Room;
import com.hotelhub.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Get all rooms
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    // Get a room by ID
    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    // Add a new room
    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    // Update an existing room
    @PutMapping("/{id}")
    public void updateRoom(@PathVariable Long id, @RequestBody Room room) {
        roomService.updateRoom(id, room);  // No return statement needed (void)
    }

    // Delete a room
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);  // No return statement needed (void)
    }
}
