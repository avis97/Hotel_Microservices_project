package com.hotel.HotelService.Service.Impl;

import com.hotel.HotelService.Entitis.Hotel;
import com.hotel.HotelService.Exception.HotelNotFoundExceptions;
import com.hotel.HotelService.Repositorys.HotelRepository;
import com.hotel.HotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    HotelRepository hotelRepository;

    public Hotel addHotel(Hotel hotel){
        String hotelId= UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        Hotel newHotel= hotelRepository.save(hotel);
        return newHotel;
    }
    public List<Hotel> allHotel(){
        List<Hotel> hotelList=hotelRepository.findAll();
        return hotelList;
    }
    public Hotel hotelFindById(String id) throws HotelNotFoundExceptions {
        Hotel hotel;
        try{
            hotel=hotelRepository.findById(id).get();
        }catch(Exception e){
            throw new HotelNotFoundExceptions("Hotel Id Is Invalid");
        }
        return hotel;
    }
}
