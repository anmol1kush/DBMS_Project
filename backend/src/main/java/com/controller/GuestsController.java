package com.hotelhub.controller;

import com.hotelhub.model.Guests;
import com.hotelhub.service.GuestsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestsController {
    private final GuestsService guestsService;

    public GuestsController(GuestsService guestsService) {
        this.guestsService = guestsService;
    }

    // ✅ Get all guests
    @GetMapping
    public List<Guests> getAllGuests() {
        return guestsService.getAllGuests();
    }

    // ✅ Get a guest by ID
    @GetMapping("/{id}")
    public ResponseEntity<Guests> getGuestById(@PathVariable int id) {
        Guests guest = guestsService.getGuestById(id);
        return guest != null ? ResponseEntity.ok(guest) : ResponseEntity.notFound().build();
    }

    // ✅ Add a new guest
    @PostMapping
public ResponseEntity<Guests> addGuest(@RequestBody Guests guest) {
    Guests savedGuest = guestsService.addGuest(guest);
if (savedGuest != null) {
    return ResponseEntity.ok(savedGuest); // ✅ guestId included
} else {
    return ResponseEntity.badRequest().build();
}

}


    // ✅ Update guest details
    @PutMapping("/{id}")
    public ResponseEntity<String> updateGuest(@PathVariable int id, @RequestBody Guests guest) {
        guest.setGuestId(id);
        int result = guestsService.updateGuest(guest);
        return result > 0 ? ResponseEntity.ok("Guest updated successfully") : ResponseEntity.notFound().build();
    }

    // ✅ Delete a guest
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuest(@PathVariable int id) {
        int result = guestsService.deleteGuest(id);
        return result > 0 ? ResponseEntity.ok("Guest deleted successfully") : ResponseEntity.notFound().build();
    }
}

