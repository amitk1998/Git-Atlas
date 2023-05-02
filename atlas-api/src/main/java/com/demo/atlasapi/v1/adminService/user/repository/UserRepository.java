package com.demo.atlasapi.v1.adminService.user.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.demo.atlasapi.v1.adminService.user.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
    
}
