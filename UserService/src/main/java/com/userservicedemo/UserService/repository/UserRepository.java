package com.userservicedemo.UserService.repository;

import com.userservicedemo.UserService.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
