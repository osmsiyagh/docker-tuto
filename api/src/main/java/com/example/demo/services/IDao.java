package com.example.demo.services;

import com.example.demo.model.User;

import java.util.List;

public interface IDao {
    void addUser(User user);
    void deleteUser(String email);
    List<User> getUsers();
    User getUser(String email);
}
