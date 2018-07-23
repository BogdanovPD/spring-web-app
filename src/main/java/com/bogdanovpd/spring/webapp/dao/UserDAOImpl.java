package com.bogdanovpd.spring.webapp.dao;

import com.bogdanovpd.spring.webapp.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl
        //implements UserDAO
{

//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public void save(User user) {
//        sessionFactory.getCurrentSession().saveOrUpdate(user);
//    }
//
//    @Override
//    public void deleteUser(long id) {
//        sessionFactory.getCurrentSession().delete(getUserById(id));
//    }
//
//    @Override
//    public List<User> selectAllUsers() {
//        Query<User> users = sessionFactory.getCurrentSession()
//                .createQuery("from User");
//        return users.getResultList();
//    }
//
//    @Override
//    public User getUserById(long id) {
//        return sessionFactory.getCurrentSession().find(User.class, id);
//    }
//
//    @Override
//    public User getUserByLogin(String login) {
//        Query<User> q = sessionFactory.getCurrentSession().createQuery("FROM User where login=:login");
//        q.setParameter("login", login);
//        List<User> list = q.getResultList();
//        if (list.isEmpty()) {
//            return null;
//        }
//        return q.getSingleResult();
//    }
}
