package com.bogdanovpd.spring.webapp.repository;

import com.bogdanovpd.spring.webapp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User getUserByLogin(String login);

    User getUserById(long id);

    Long deleteUserById(long id);

    List<User> findAll();
}
