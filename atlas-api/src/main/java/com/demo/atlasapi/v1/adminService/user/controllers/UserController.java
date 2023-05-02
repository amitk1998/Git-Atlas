package com.demo.atlasapi.v1.adminService.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.atlasapi.v1.adminService.user.models.User;
import com.demo.atlasapi.v1.adminService.user.repository.UserRepository;
import com.demo.atlasapi.v1.adminService.user.service.UserService;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/list")
    public Page<User> getAllUsersList(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int limit,
        @RequestParam(required = false) String user_type)
        {
             // Create a pageable object with the given page and limit
            Pageable pageable = PageRequest.of(page, limit);
            if (user_type != null && !user_type.isEmpty()) {
                return userRepository.findAllByUserType(user_type, pageable);
            } else {
                return userRepository.findAll(pageable);
            }
        }
}
