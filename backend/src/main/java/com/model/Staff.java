package com.hotelhub.model;

import java.sql.Date;

public class Staff {
    private int staffId;
    private int userId;
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private Date hireDate;

    // Constructors
    public Staff() {}

    public Staff(int staffId, int userId, String fullName, String position, String email, String phone, double salary, Date hireDate) {
        this.staffId = staffId;
        this.userId = userId;
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    // Getters and Setters
    public int getStaffId() { return staffId; }
    public void setStaffId(int staffId) { this.staffId = staffId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }
}

