package com.zapacademy.service;

import com.zapacademy.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
