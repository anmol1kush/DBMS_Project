package com.hotelhub.model;

public class Guests {
    private int guestId;
    private int userId;
    private String address;
    private String city;
    private String country;
    private String idProofType;
    private String idProofNumber;

    // Constructors
    public Guests() {}

    public Guests(int guestId, int userId, String address, String city, String country, String idProofType, String idProofNumber) {
        this.guestId = guestId;
        this.userId = userId;
        this.address = address;
        this.city = city;
        this.country = country;
        this.idProofType = idProofType;
        this.idProofNumber = idProofNumber;
    }

    // Getters and Setters
    public int getGuestId() { return guestId; }
    public void setGuestId(int guestId) { this.guestId = guestId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getIdProofType() { return idProofType; }
    public void setIdProofType(String idProofType) { this.idProofType = idProofType; }

    public String getIdProofNumber() { return idProofNumber; }
    public void setIdProofNumber(String idProofNumber) { this.idProofNumber = idProofNumber; }
}

