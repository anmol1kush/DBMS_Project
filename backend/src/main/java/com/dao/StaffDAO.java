package com.hotelhub.dao;

import com.hotelhub.model.Staff;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StaffDAO {
    private final JdbcTemplate jdbcTemplate;

    public StaffDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper to map SQL result to Staff object
    private RowMapper<Staff> staffRowMapper = new RowMapper<>() {
        @Override
        public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Staff(
                rs.getInt("staff_id"),
                rs.getInt("user_id"),
                rs.getString("full_name"),
                rs.getString("position"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getDouble("salary"),
                rs.getDate("hire_date")
            );
        }
    };

    // ✅ Add a new staff member
    public int saveStaff(Staff staff) {
        String sql = "INSERT INTO Staff (user_id, full_name, position, email, phone, salary, hire_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, staff.getUserId(), staff.getFullName(), staff.getPosition(),
                staff.getEmail(), staff.getPhone(), staff.getSalary(), staff.getHireDate());
    }

    // ✅ Get all staff members
    public List<Staff> getAllStaff() {
        String sql = "SELECT * FROM Staff";
        return jdbcTemplate.query(sql, staffRowMapper);
    }

    // ✅ Get a staff member by ID
    public Staff getStaffById(int staffId) {
        String sql = "SELECT * FROM Staff WHERE staff_id = ?";
        return jdbcTemplate.queryForObject(sql, staffRowMapper, staffId);
    }

    // ✅ Update staff details
    public int updateStaff(Staff staff) {
        String sql = "UPDATE Staff SET user_id=?, full_name=?, position=?, email=?, phone=?, salary=?, hire_date=? WHERE staff_id=?";
        return jdbcTemplate.update(sql, staff.getUserId(), staff.getFullName(), staff.getPosition(),
                staff.getEmail(), staff.getPhone(), staff.getSalary(), staff.getHireDate(), staff.getStaffId());
    }

    // ✅ Delete a staff member
    public int deleteStaff(int staffId) {
        String sql = "DELETE FROM Staff WHERE staff_id = ?";
        return jdbcTemplate.update(sql, staffId);
    }
}

