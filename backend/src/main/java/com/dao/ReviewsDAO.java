package com.hotelhub.dao;

import com.hotelhub.model.Reviews;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewsDAO {
    private final JdbcTemplate jdbcTemplate;

    public ReviewsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping result sets to Reviews objects
    private RowMapper<Reviews> reviewRowMapper = (rs, rowNum) -> new Reviews(
            rs.getInt("review_id"),
            rs.getInt("guest_id"),
            rs.getInt("room_id"),
            rs.getInt("rating"),
            rs.getString("review_text")
    );

    // ✅ Add a new review
    public int saveReview(Reviews review) {
        String sql = "INSERT INTO Reviews (guest_id, room_id, rating, review_text) VALUES (?, ?, ?, ?)";
        try {
            System.out.println("📝 Inserting review into DB: " + review);
            return jdbcTemplate.update(sql, review.getGuestId(), review.getRoomId(), review.getRating(), review.getReviewText());
        } catch (Exception e) {
            System.err.println("❌ Error while saving review: " + e.getMessage());
            return 0;
        }
    }

    // ✅ Get all reviews
    public List<Reviews> getAllReviews() {
        String sql = "SELECT * FROM Reviews";
        return jdbcTemplate.query(sql, reviewRowMapper);
    }

    // ✅ Get a review by ID
    public Reviews getReviewById(int reviewId) {
        String sql = "SELECT * FROM Reviews WHERE review_id = ?";
        return jdbcTemplate.queryForObject(sql, reviewRowMapper, reviewId);
    }

    // ✅ Update a review
    public int updateReview(Reviews review) {
        String sql = "UPDATE Reviews SET guest_id = ?, room_id = ?, rating = ?, review_text = ? WHERE review_id = ?";
        return jdbcTemplate.update(sql, review.getGuestId(), review.getRoomId(), review.getRating(), review.getReviewText(), review.getReviewId());
    }

    // ✅ Delete a review
    public int deleteReview(int reviewId) {
        String sql = "DELETE FROM Reviews WHERE review_id = ?";
        return jdbcTemplate.update(sql, reviewId);
    }
}

