package com.userService.user_service.Exception;

import lombok.experimental.UtilityClass;

public class UserNotFoundExceptions extends Exception{
    public UserNotFoundExceptions(String msg){
        super(msg);
    }
}
