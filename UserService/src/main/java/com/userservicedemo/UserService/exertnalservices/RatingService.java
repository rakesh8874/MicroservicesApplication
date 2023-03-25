package com.userservicedemo.UserService.exertnalservices;

import com.userservicedemo.UserService.domain.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient("rating-service")
public interface RatingService {


    @GetMapping("/rating-service/ratings/{userId}")
    List<Rating> getRating(@PathVariable String userId);


    @PostMapping("/rating-service/rating")
    Rating createRating(@RequestBody Rating values);



}
