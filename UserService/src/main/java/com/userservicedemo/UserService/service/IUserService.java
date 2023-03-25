package com.userservicedemo.UserService.service;

import com.userservicedemo.UserService.domain.User;

import java.util.List;

public interface IUserService {

 User createUser(User user);

 User getUserById(String userId);

 List<User> getAllUsers();

 boolean deleteUser(String id);

 User updateUser(User user);



}
