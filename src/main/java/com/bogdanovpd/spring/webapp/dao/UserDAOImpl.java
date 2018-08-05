package com.bogdanovpd.spring.webapp.dao;

import com.bogdanovpd.spring.webapp.model.User;
import com.bogdanovpd.spring.webapp.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO
{

    @Autowired
    private UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        repository.delete(getUserById(id));
    }

    @Override
    public List<User> selectAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User getUserByLogin(String login) {
        return repository.getUserByLogin(login);
    }
}
