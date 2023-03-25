package com.hotelservicedemo.hotelservice.controller;


import com.hotelservicedemo.hotelservice.domain.Hotel;
import com.hotelservicedemo.hotelservice.service.IServiceHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel-service")
public class HotelController {

    @Autowired
    private IServiceHotel serviceHotel;

    @PostMapping("/hotel")
    public ResponseEntity<?> createHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(serviceHotel.createHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping("/hotels")
    public ResponseEntity<?> getAllHotels(){
        return new ResponseEntity<>(serviceHotel.getAllHotels(), HttpStatus.FOUND);
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<?> getHotelAsPerId(@PathVariable String id){
        return new ResponseEntity<>(serviceHotel.getHotelFromId(id), HttpStatus.OK);
    }

}
