package com.hotel.HotelService.Controller;

import com.hotel.HotelService.Entitis.Hotel;
import com.hotel.HotelService.Exception.HotelNotFoundExceptions;
import com.hotel.HotelService.Repositorys.HotelRepository;
import com.hotel.HotelService.Service.HotelService;
import com.hotel.HotelService.Service.Impl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController{
    @Autowired
    HotelServiceImpl hotelService;

    @PostMapping("/addHotel")
    public Hotel addHotel(@RequestBody Hotel hotel){
        Hotel newHotel=hotelService.addHotel(hotel);
        return newHotel;
    }
    @GetMapping("/getAllHotel")
    public List<Hotel> allHotel(){
        List<Hotel> hotelList=hotelService.allHotel();
        return hotelList;
    }
    @GetMapping("/findHotelById/{id}")
    public ResponseEntity findHotelById(@PathVariable("id") String id) throws HotelNotFoundExceptions{
        Hotel hotel;
        try{
            hotel=hotelService.hotelFindById(id);
        }catch (HotelNotFoundExceptions e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hotel,HttpStatus.ACCEPTED);
    }
}
