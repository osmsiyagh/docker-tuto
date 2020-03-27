package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.services.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private IDao daoService;

    @RequestMapping(
            value = "/addUser",
            method = RequestMethod.POST
    )
    public String addUser(@RequestBody User user) {
        daoService.addUser(user);
        return "User "+user.getEmail()+" added successfully";
    }

    @RequestMapping(
            value = "/getUser",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public User getUser(@RequestParam String email) {
        return daoService.getUser(email);
    }

    @RequestMapping(
            value = "/getUsers",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public List<User> getUsers() {
        return daoService.getUsers();
    }

    @RequestMapping(
            value = "/deleteUser",
            method = RequestMethod.DELETE
    )
    public String deleteUser(@RequestParam String email) {
        daoService.deleteUser(email);
        return "User "+email+" deleted successfully";
    }






}
