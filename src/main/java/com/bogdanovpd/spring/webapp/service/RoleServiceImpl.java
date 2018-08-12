package com.bogdanovpd.spring.webapp.service;

import com.bogdanovpd.spring.webapp.dao.RolesDao;
import com.bogdanovpd.spring.webapp.model.Role;
import com.bogdanovpd.spring.webapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RolesDao dao;

    @Override
    public List<Role> getAllRoles() {
        return dao.findAll();
    }

    @Override
    public Set<String> getAllRoleNames() {
        return getAllRoles().stream().map(role ->
                role.getName()).collect(Collectors.toSet());
    }

    @Override
    public void save(Role role){
        dao.save(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return dao.getRoleByName(name);
    }

    @Override
    public Role getRoleByID(Long id) {
        return dao.getRoleById(id);
    }


}
