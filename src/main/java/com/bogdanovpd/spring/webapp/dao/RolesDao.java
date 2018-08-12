package com.bogdanovpd.spring.webapp.dao;

import com.bogdanovpd.spring.webapp.model.Role;

import java.util.List;
import java.util.Set;

public interface RolesDao {
    List<Role> findAll();
    Role getRoleByName(String name);
    void save(Role role);
    Role getRoleById(Long id);
}
