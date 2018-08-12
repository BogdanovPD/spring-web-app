package com.bogdanovpd.spring.webapp.service;

import com.bogdanovpd.spring.webapp.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getAllRoles();
    Set<String> getAllRoleNames();
    void save(Role role);
    Role getRoleByName(String name);
    Role getRoleByID(Long id);
}
