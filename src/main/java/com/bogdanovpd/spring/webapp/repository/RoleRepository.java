package com.bogdanovpd.spring.webapp.repository;

import com.bogdanovpd.spring.webapp.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findAll();
    Role getRoleByName(String name);
}
