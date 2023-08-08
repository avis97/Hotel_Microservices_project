package com.userService.user_service.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel{
    private String hotelId;
    private String hotelName;
    private String location;
    private String aboutHotel;
}
