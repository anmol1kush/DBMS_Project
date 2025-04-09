package com.hotelhub.model;

public class Room {
    private Long roomId;         // Changed from id
    private String roomNumber;   // Changed from int to String
    private String roomType;     // ENUM stored as String
    private double pricePerNight;
    private String status;       // ENUM stored as String
    private int maxCapacity;

    // Constructor
    public Room(Long roomId, String roomNumber, String roomType, double pricePerNight, String status, int maxCapacity) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.status = status;
        this.maxCapacity = maxCapacity;
    }
   
    // Getters and Setters
    public Long getRoomId() { return roomId; }
    public void setRoomId(Long roomId) { this.roomId = roomId; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }
}
