package com.rating.ratingService.Repository;

import com.rating.ratingService.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface RatingRepository extends JpaRepository<Rating,String>{

    List<Rating> findByUserId(String id);
    List<Rating> findByHotelId(String id);

}
