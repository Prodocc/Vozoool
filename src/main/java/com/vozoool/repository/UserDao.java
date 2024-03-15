package com.vozoool.repository;

import com.vozoool.entity.User;

import java.util.List;

public interface UserDao {

    User findByEmail(String email);

    List<User> getAll();

    void addUser(User user);
}
