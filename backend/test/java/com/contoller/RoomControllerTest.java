package com.hotelhub.controller;

import com.hotelhub.model.Room;
import com.hotelhub.service.RoomService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RoomControllerTest {

    @Mock
    private RoomService roomService;

    @InjectMocks
    private RoomController roomController;

    @Test
    public void testGetRoomById() {
        Room room = new Room(1L, "Single", 101, 150.0);
        when(roomService.getRoomById(1L)).thenReturn(room);
        
        Room response = roomController.getRoomById(1L);
        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Single", response.getRoomType());
    }
}
