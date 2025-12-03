package com.iwl.security.service;

import com.iwl.security.entity.User;

import java.util.Optional;

public interface IUserService {

    Integer saveUser(User user);
    Optional<User> findByUsername(String username);
}
