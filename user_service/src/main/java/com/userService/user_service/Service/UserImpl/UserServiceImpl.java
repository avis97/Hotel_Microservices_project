package com.userService.user_service.Service.UserImpl;

import com.userService.user_service.Entities.Hotel;
import com.userService.user_service.Entities.Rating;
import com.userService.user_service.Entities.User;
import com.userService.user_service.Exception.UserNotFoundExceptions;
import com.userService.user_service.Repository.UserRepository;
import com.userService.user_service.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;
    private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

    public User addUser(User user){
        String randomUserId= UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }
    public List<User> getAllUser(){

        List<User> list=userRepository.findAll();
        return list;
    }
    public User getUserById(String userId) throws UserNotFoundExceptions {
        User user;
        try{
            user=userRepository.findById(userId).get();


            Rating[] ratingForUser=restTemplate.getForObject("http://RATING-SERVICE/rating/getRatingByUserId/"+user.getUserId(),Rating[].class);
            List<Rating> ratings=Arrays.stream(ratingForUser).toList();

            List<Rating> ratingList=ratings.stream().map(rating -> {
            //url localhost:8093/hotel/findHotelById/7679bec2-9ace-46a7-b754-df0a31a1a469
                ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/findHotelById/"+rating.getHotelId(), Hotel.class);
                Hotel hotel=forEntity.getBody();
                rating.setHotel(hotel);
                return rating;
            }).collect(Collectors.toList());

            logger.info("{}",ratingForUser);
            user.setRatings(ratingList);
        }catch(Exception e){
            throw new UserNotFoundExceptions("User is not found");
        }
        return user;
    }
}
