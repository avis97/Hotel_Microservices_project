package com.rating.ratingService.Controller;

import com.rating.ratingService.Entity.Rating;
import com.rating.ratingService.Service.Impl.RatingServiceImpl;
import com.rating.ratingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("/rating")
public class RatingController{

    @Autowired
    RatingServiceImpl ratingService;

    @PostMapping("/addRating")
    public Rating addRating(@RequestBody Rating rating){
        Rating ratingNew=ratingService.addRating(rating);
        return ratingNew;
    }
    @GetMapping("/getAllRating")
    public List<Rating> allRating(){
        return ratingService.allRating();
    }
    @GetMapping("/getRatingByUserId/{id}")
    public List<Rating> getRatingByUserId(@PathVariable("id") String id){
        return ratingService.getAllRatingByUserId(id);
    }
    @GetMapping("/getRatingByHotelId/{id}")
    public List<Rating> getRatingByHotelId(@PathVariable("id") String id){
        return ratingService.getAllRatingByHotelId(id);
    }
}
