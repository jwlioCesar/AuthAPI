package com.authAPI.AuthAPI.repositories;

import com.authAPI.AuthAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Long, User> {



}
