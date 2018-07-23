package com.bogdanovpd.spring.webapp.service;

import com.bogdanovpd.spring.webapp.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    User getUserById(long id);

    User getUserByLogin(String login);
}
