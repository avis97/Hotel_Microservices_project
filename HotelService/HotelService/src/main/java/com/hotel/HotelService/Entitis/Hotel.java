package com.hotel.HotelService.Entitis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="hotel_table")
public class Hotel{
    @Id
    @Column(name="hotel_id")
    private String hotelId;
    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name="location")
    private String location;
    @Column(name="about_hotel")
    private String aboutHotel;
}
