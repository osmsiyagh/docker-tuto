package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaoService implements IDao{

    @Autowired
    private UserRepository repository;

    public void deleteUser(String email) {
        repository.deleteById(email);
    }

    public void addUser(User user) {
        repository.save(user);
    }

    public List<User> getUsers() { return repository.findAll(); }

    public User getUser(String email) { return repository.findById(email).get(); }

}
