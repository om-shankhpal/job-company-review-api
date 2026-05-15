package com.example.demo.controller;

import com.example.demo.model.Review;
import com.example.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @PostMapping
    public ResponseEntity<String> postReview(@PathVariable Long companyId, @RequestBody Review review){
        reviewService.postReview(companyId,review);
        return ResponseEntity.ok("Review posted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id){
        if (reviewService.getReviewById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long id) {
        if (reviewService.getReviewById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        reviewService.deleteReviewById(id);
        return ResponseEntity.ok("Review deleted successfully");
    }
}
