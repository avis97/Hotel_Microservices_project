package com.rating.ratingService.Service.Impl;

import com.rating.ratingService.Entity.Rating;
import com.rating.ratingService.Repository.RatingRepository;
import com.rating.ratingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    RatingRepository repository;
    public Rating addRating(Rating rating){
        String ratingId= UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        repository.save(rating);
        return rating;
    }
    public List<Rating> allRating(){
        List<Rating> ratingList=repository.findAll();
        return ratingList;
    }
    public List<Rating> getAllRatingByUserId(String id){
        return repository.findByUserId(id);
    }
    public List<Rating> getAllRatingByHotelId(String id){
        return repository.findByHotelId(id);
    }

}
