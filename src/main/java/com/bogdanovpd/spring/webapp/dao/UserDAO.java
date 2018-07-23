package com.bogdanovpd.spring.webapp.dao;

import com.bogdanovpd.spring.webapp.model.User;

import java.util.List;

public interface UserDAO {
    void save(User user);

    void deleteUser(long id);

    List<User> selectAllUsers();

    User getUserById(long id);

    User getUserByLogin(String login);
}
