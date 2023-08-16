package com.rating.ratingService.Service;

import com.rating.ratingService.Entity.Rating;

import java.util.List;

public interface RatingService{

    Rating addRating(Rating rating);
    List<Rating> allRating();
    List<Rating> getAllRatingByUserId(String id);
    List<Rating> getAllRatingByHotelId(String id);
}
