package com.bogdanovpd.spring.webapp.controller;

import com.bogdanovpd.spring.webapp.model.Role;
import com.bogdanovpd.spring.webapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "roles-rest")
public class RoleRestController {

    @Autowired
    private RoleService service;

    @GetMapping
    public List<Role> readAll() {
        return service.getAllRoles();
    }

    @GetMapping("{field}")
    public Role read(@PathVariable String field) {
        try {
            long id = Long.valueOf(field);
            return service.getRoleByID(id);
        } catch (NumberFormatException e) {
            return service.getRoleByName(field);
        }
    }

}
