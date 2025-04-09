package com.hotelhub.controller;

import com.hotelhub.model.Staff;
import com.hotelhub.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    // ✅ Get all staff members
    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    // ✅ Get a staff member by ID
    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable int id) {
        Staff staff = staffService.getStaffById(id);
        return staff != null ? ResponseEntity.ok(staff) : ResponseEntity.notFound().build();
    }

    
    @PostMapping
    public ResponseEntity<String> addStaff(@RequestBody Staff staff) {
        int result = staffService.addStaff(staff);
        return result > 0 ? ResponseEntity.ok("Staff added successfully") : ResponseEntity.badRequest().body("Failed to add staff");
    }

    // ✅ Update staff details
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStaff(@PathVariable int id, @RequestBody Staff staff) {
        staff.setStaffId(id);
        int result = staffService.updateStaff(staff);
        return result > 0 ? ResponseEntity.ok("Staff updated successfully") : ResponseEntity.notFound().build();
    }

    // ✅ Delete a staff member
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable int id) {
        int result = staffService.deleteStaff(id);
        return result > 0 ? ResponseEntity.ok("Staff deleted successfully") : ResponseEntity.notFound().build();
    }
}

