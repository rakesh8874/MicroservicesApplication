package com.userservicedemo.UserService.exertnalservices;

import com.userservicedemo.UserService.domain.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="hotel-service")
public interface HotelService {

    @GetMapping("/hotel-service/hotel/{id}")
    Hotel getHotel(@PathVariable String id);

}
