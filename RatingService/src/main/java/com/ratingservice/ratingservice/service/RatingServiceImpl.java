package com.ratingservice.ratingservice.service;

import com.ratingservice.ratingservice.domain.Rating;
import com.ratingservice.ratingservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements IRatingService{

    @Autowired
    RatingRepository repository;

    @Override
    public Rating createRating(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String id) {
        return repository.findByUserId(id);
    }

    @Override
    public List<Rating> getRatingByHotelId(String id) {
        return repository.findByHotelId(id);
    }
}
