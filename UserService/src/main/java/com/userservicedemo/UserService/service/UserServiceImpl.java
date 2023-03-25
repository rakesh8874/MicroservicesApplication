package com.userservicedemo.UserService.service;

import com.userservicedemo.UserService.domain.Hotel;
import com.userservicedemo.UserService.domain.Rating;
import com.userservicedemo.UserService.domain.User;
import com.userservicedemo.UserService.exceptions.ResourceNotFoundException;
import com.userservicedemo.UserService.exertnalservices.HotelService;
import com.userservicedemo.UserService.exertnalservices.RatingService;
import com.userservicedemo.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

     private UserRepository userRepository;
     private RestTemplate restTemplate;
    private HotelService hotelService;
    private RatingService ratingService;

   @Autowired
    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate, HotelService hotelService, RatingService ratingService) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
        this.hotelService = hotelService;
        this.ratingService = ratingService;
    }

    @Override
    public User createUser(User user) {
        if(userRepository.findById(user.getUserId()).isPresent()) {
            return null;
        }
        return userRepository.save(user);
    }
    @Override
    public User getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User With Given Id is Not Available "+userId));
        Rating [] usersRating = restTemplate.getForObject("http://rating-service/rating-service/ratings/"+user.getUserId(), Rating[].class);
        List<Rating> ratingList  =  Arrays.stream(usersRating).toList();
        List<Rating> ratingList1 = ratingList.stream().peek(rating -> {
           // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://hotel-service/hotel-service/hotel/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setGetHotel(hotel);
        }).toList();

        user.setUserRating(ratingList1);
       return user;
     }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public boolean deleteUser(String id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User updateUser(User user) {
        if(userRepository.findById(user.getUserId()).isEmpty()) {
            return null;
        }else{
            User existUser = userRepository.findById(user.getUserId()).get();
            existUser.setUserId(user.getUserId());
            existUser.setName(user.getName());
            existUser.setEmail(user.getEmail());
            existUser.setPassword(user.getPassword());
           return userRepository.save(existUser);
        }
    }
}
