package com.userService.user_service.Service;

import com.userService.user_service.Entities.User;
import com.userService.user_service.Exception.UserNotFoundExceptions;

import java.util.List;

public interface UserService{
    User addUser(User user);
    List<User> getAllUser();
    User getUserById(String userId) throws UserNotFoundExceptions;
}
