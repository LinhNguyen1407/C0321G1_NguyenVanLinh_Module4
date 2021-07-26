package com.codegym.model.service;

import com.codegym.model.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);
}
