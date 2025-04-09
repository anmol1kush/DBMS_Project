package com.hotelhub.controller;

import com.hotelhub.model.User;
import com.hotelhub.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            User savedUser = userService.addUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            e.printStackTrace(); // or use logger
            return ResponseEntity.status(500).body("Error during signup: " + e.getMessage());
        }
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User user) {
        user.setUserId(id);
        userService.updateUser(user);
        return ResponseEntity.ok("User updated successfully");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User foundUser = userService.authenticateUser(user.getUsername(), user.getPassword());
        if (foundUser != null) {
            // 🔍 Now get guestId using foundUser.getUserId()
            Integer guestId = userService.getGuestIdByUserId(foundUser.getUserId());
    
            // 📦 Send both userId and guestId
            return ResponseEntity.ok(new LoginResponse(foundUser.getUserId(), guestId));
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
    
    // ✅ Create an inner static class for response structure
    static class LoginResponse {
        private int userId;
        private Integer guestId;
    
        public LoginResponse(int userId, Integer guestId) {
            this.userId = userId;
            this.guestId = guestId;
        }
    
        public int getUserId() {
            return userId;
        }
    
        public Integer getGuestId() {
            return guestId;
        }
    }
    


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
