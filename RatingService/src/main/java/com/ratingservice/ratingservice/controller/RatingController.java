package com.ratingservice.ratingservice.controller;
import com.ratingservice.ratingservice.domain.Rating;
import com.ratingservice.ratingservice.service.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating-service")
public class RatingController {

    @Autowired
    private IRatingService ratingService;

    @PostMapping("/rating")
    public ResponseEntity<?> createRating(@RequestBody Rating rating){
        return new ResponseEntity<>(ratingService.createRating(rating), HttpStatus.CREATED);
    }

    @GetMapping("/ratings")
    public ResponseEntity<?> getRatings(){
        return new ResponseEntity<>(ratingService.getRatings(), HttpStatus.FOUND);
    }

    @GetMapping("/ratings/{userId}")
    public ResponseEntity<?> getRatingByUserId(@PathVariable String userId){
        return new ResponseEntity<>(ratingService.getRatingByUserId(userId), HttpStatus.FOUND);
    }

    @GetMapping("/rating/{hotelId}")
    public ResponseEntity<?> getRatingByHotelId(@PathVariable String hotelId){
        return new ResponseEntity<>(ratingService.getRatingByHotelId(hotelId), HttpStatus.FOUND);
    }

}
