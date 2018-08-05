package com.bogdanovpd.spring.webapp.service;

import com.bogdanovpd.spring.webapp.dao.UserDAO;
import com.bogdanovpd.spring.webapp.model.User;
import com.bogdanovpd.spring.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao;

    @Override
    public void save(User user) {
        dao.save(user);
    }

    @Override
    public void deleteUser(long id) {
        dao.deleteUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.selectAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return dao.getUserById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return dao.getUserByLogin(login);
    }
}
