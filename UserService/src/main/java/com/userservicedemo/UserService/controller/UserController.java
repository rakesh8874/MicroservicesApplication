package com.userservicedemo.UserService.controller;

import com.userservicedemo.UserService.domain.User;
import com.userservicedemo.UserService.service.IUserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-service")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){

        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
   // @CircuitBreaker(name="rating_hotel_breaker", fallbackMethod = "ratingHotelFallback")
  // @Retry(name="rating_hotel_service", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name="user_rate_limiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserAsPerId(@PathVariable String userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
      User user = User.builder()
                .email("abc@gmail.com")
                .name("ABCD")
                .userId("abc123").build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId){
        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

}
