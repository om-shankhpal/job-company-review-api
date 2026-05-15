package com.example.demo.service;

import com.example.demo.model.Company;
import com.example.demo.model.Review;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public void postReview(Long companyId, Review review){
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        review.setCompany(company);
        reviewRepository.save(review);
    }

    public Review getReviewById(Long id){
        return reviewRepository.findById(id).orElse(null);
    }

    public void deleteReviewById(Long id){
        reviewRepository.deleteById(id);
    }
}
