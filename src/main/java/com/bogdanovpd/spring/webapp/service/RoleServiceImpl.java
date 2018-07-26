package com.bogdanovpd.spring.webapp.service;

import com.bogdanovpd.spring.webapp.model.Role;
import com.bogdanovpd.spring.webapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    @Override
    public Set<String> getAllRoleNames() {
        return getAllRoles().stream().map(role ->
                role.getName()).collect(Collectors.toSet());
    }
}
