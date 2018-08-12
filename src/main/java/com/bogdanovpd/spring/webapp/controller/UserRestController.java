package com.bogdanovpd.spring.webapp.controller;

import com.bogdanovpd.spring.webapp.model.User;
import com.bogdanovpd.spring.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users-rest")
public class UserRestController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> readAll() {
        return service.getAllUsers();
    }

    @GetMapping("{field}")
    public User read(@PathVariable String field) {
        try {
            long id = Long.valueOf(field);
            return service.getUserById(id);
        } catch (NumberFormatException e) {
            return service.getUserByLogin(field);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user) {
        if (service.getUserById(user.getId()) == null) {
            service.save(user);
        }
        return user;
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User update(@PathVariable long id, @RequestBody User user){
        user.setId(id);
        service.save(user);
        return user;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        service.deleteUser(id);
    }

}
