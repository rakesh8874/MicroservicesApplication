package com.hotelservicedemo.hotelservice.repository;

import com.hotelservicedemo.hotelservice.domain.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
}
