package com.hotelhub.service;

import com.hotelhub.dao.StaffDAO;
import com.hotelhub.model.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private final StaffDAO staffDAO;

    public StaffService(StaffDAO staffDAO) {
        this.staffDAO = staffDAO;
    }

   public int addStaff(Staff staff) {
        try {
            System.out.println("Guest received: " + staff.getUserId());
            return staffDAO.saveStaff(staff);
        } catch (Exception e) {
            e.printStackTrace(); // 🔥 This will print exact reason
            return 0;
        }
    }

    public List<Staff> getAllStaff() {
        return staffDAO.getAllStaff();
    }

    public Staff getStaffById(int staffId) {
        return staffDAO.getStaffById(staffId);
    }

    public int updateStaff(Staff staff) {
        return staffDAO.updateStaff(staff);
    }

    public int deleteStaff(int staffId) {
        return staffDAO.deleteStaff(staffId);
    }
}
