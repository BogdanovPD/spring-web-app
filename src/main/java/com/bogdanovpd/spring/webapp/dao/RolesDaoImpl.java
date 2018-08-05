package com.bogdanovpd.spring.webapp.dao;

import com.bogdanovpd.spring.webapp.model.Role;
import com.bogdanovpd.spring.webapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RolesDaoImpl implements RolesDao {

    @Autowired
    private RoleRepository repository;

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role getRoleByName(String name) {
        return repository.getRoleByName(name);
    }

    @Override
    public void save(Role role) {
        repository.save(role);
    }
}
