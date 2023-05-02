package com.demo.atlasapi.v1.adminService.user.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.atlasapi.v1.adminService.user.repository.UserRepository;
import com.demo.atlasapi.v1.adminService.user.service.UserService;
import com.demo.atlasapi.v1.adminService.user.models.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
