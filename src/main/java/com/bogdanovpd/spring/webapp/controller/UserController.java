package com.bogdanovpd.spring.webapp.controller;

import com.bogdanovpd.spring.webapp.model.User;
import com.bogdanovpd.spring.webapp.service.RoleService;
import com.bogdanovpd.spring.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public String main(Model model) {
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("authUser", context.getAuthentication().getName());
        return "auth";
    }

    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("err", "Invalid Credentials provided");
        }
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("authUser", context.getAuthentication().getName());
        return "auth";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @GetMapping("/user")
    public String user(Model model) {
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("message", "You are logged in as "
                + context.getAuthentication().getName());
        return "user";
    }

    @PostMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "userForm";
    }

    @GetMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/users/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "userForm";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/admin";
    }

}
