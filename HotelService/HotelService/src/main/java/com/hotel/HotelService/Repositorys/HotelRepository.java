package com.hotel.HotelService.Repositorys;

import com.hotel.HotelService.Entitis.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String>{
}
