package com.hotelhub.service;

import com.hotelhub.dao.GuestsDAO;
import com.hotelhub.model.Guests;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestsService {
    private final GuestsDAO guestsDAO;

    public GuestsService(GuestsDAO guestsDAO) {
        this.guestsDAO = guestsDAO;
    }

    public Guests addGuest(Guests guest) {
        try {
            System.out.println("Guest received: " + guest.getUserId());
    
            Guests savedGuest = guestsDAO.saveGuest(guest);
            return savedGuest; // will be null if insert failed
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    

    public List<Guests> getAllGuests() {
        return guestsDAO.getAllGuests();
    }

    public Guests getGuestById(int guestId) {
        return guestsDAO.getGuestById(guestId);
    }

    public int updateGuest(Guests guest) {
        return guestsDAO.updateGuest(guest);
    }

    public int deleteGuest(int guestId) {
        return guestsDAO.deleteGuest(guestId);
    }
}
