package com.hotelhub.service;

import com.hotelhub.dao.ReviewsDAO;
import com.hotelhub.model.Reviews;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService {
    private final ReviewsDAO reviewsDAO;

    public ReviewsService(ReviewsDAO reviewsDAO) {
        this.reviewsDAO = reviewsDAO;
    }

    public int addReview(Reviews review) {
        return reviewsDAO.saveReview(review);
    }

    public List<Reviews> getAllReviews() {
        return reviewsDAO.getAllReviews();
    }

    public Reviews getReviewById(int reviewId) {
        return reviewsDAO.getReviewById(reviewId);
    }

    public int updateReview(Reviews review) {
        return reviewsDAO.updateReview(review);
    }

    public int deleteReview(int reviewId) {
        return reviewsDAO.deleteReview(reviewId);
    }
}

