package com.userService.user_service.Controller;

import com.userService.user_service.Entities.User;
import com.userService.user_service.Exception.UserNotFoundExceptions;
import com.userService.user_service.Service.Impl.UserServiceImpl;
import com.userService.user_service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    UserServiceImpl userService;
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        User addUser=userService.addUser(user);
        return addUser;
    }
    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/getUserById/{id}")
    public ResponseEntity getUserById(@PathVariable("id") String userId) throws UserNotFoundExceptions {
        User user;
        try{
            user=userService.getUserById(userId);
        }catch (UserNotFoundExceptions e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(user,HttpStatus.ACCEPTED);
    }
}
