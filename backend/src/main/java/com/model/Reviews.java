package com.hotelhub.model;

public class Reviews {
    private int reviewId;
    private int guestId;
    private int roomId;
    private int rating;
    private String reviewText;

    // Constructors
    public Reviews() {}

    public Reviews(int reviewId, int guestId, int roomId, int rating, String reviewText) {
        this.reviewId = reviewId;
        this.guestId = guestId;
        this.roomId = roomId;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    // Getters and Setters
    public int getReviewId() { return reviewId; }
    public void setReviewId(int reviewId) { this.reviewId = reviewId; }

    public int getGuestId() { return guestId; }
    public void setGuestId(int guestId) { this.guestId = guestId; }

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getReviewText() { return reviewText; }
    public void setReviewText(String reviewText) { this.reviewText = reviewText; }
}

