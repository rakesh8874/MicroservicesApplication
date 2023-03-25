package com.ratingservice.ratingservice.service;

import com.ratingservice.ratingservice.domain.Rating;

import java.util.List;

public interface IRatingService {

    Rating createRating(Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingByUserId(String id);

    List<Rating> getRatingByHotelId(String id);

}
