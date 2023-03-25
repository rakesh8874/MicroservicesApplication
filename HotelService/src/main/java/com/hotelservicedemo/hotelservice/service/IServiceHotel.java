package com.hotelservicedemo.hotelservice.service;

import com.hotelservicedemo.hotelservice.domain.Hotel;

import java.util.List;

public interface IServiceHotel {

    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotelFromId(String id);

}
