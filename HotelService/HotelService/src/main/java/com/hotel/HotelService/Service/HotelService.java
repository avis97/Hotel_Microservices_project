package com.hotel.HotelService.Service;

import com.hotel.HotelService.Entitis.Hotel;
import com.hotel.HotelService.Exception.HotelNotFoundExceptions;

import java.util.List;

public interface HotelService{

    Hotel addHotel(Hotel hotel);
    List<Hotel> allHotel();
    Hotel hotelFindById(String id) throws HotelNotFoundExceptions;
}
