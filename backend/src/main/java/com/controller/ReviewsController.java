package com.hotelhub.controller;

import com.hotelhub.model.Reviews;
import com.hotelhub.service.ReviewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    private final ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    // ✅ Get all reviews
    @GetMapping
    public List<Reviews> getAllReviews() {
        return reviewsService.getAllReviews();
    }

    // ✅ Get a review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Reviews> getReviewById(@PathVariable int id) {
        Reviews review = reviewsService.getReviewById(id);
        return review != null ? ResponseEntity.ok(review) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestBody Reviews review) {
        System.out.println("📥 Received review: " + review);  // 👈 Add this line
        int result = reviewsService.addReview(review);
        if (result > 0) {
            System.out.println("✅ Review inserted successfully");
            return ResponseEntity.ok("Review added successfully");
        } else {
            System.out.println("❌ Review insert failed");
            return ResponseEntity.badRequest().body("Failed to add review");
        }
    }
    

    // ✅ Update review details
    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable int id, @RequestBody Reviews review) {
        review.setReviewId(id);
        int result = reviewsService.updateReview(review);
        return result > 0 ? ResponseEntity.ok("Review updated successfully") : ResponseEntity.notFound().build();
    }

    // ✅ Delete a review
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable int id) {
        int result = reviewsService.deleteReview(id);
        return result > 0 ? ResponseEntity.ok("Review deleted successfully") : ResponseEntity.notFound().build();
    }
}

