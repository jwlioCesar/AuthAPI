package com.authAPI.AuthAPI.controllers;

import com.authAPI.AuthAPI.Services.UserService;
import com.authAPI.AuthAPI.dto.LoginDTO;
import com.authAPI.AuthAPI.dto.RegisterDTO;
import com.authAPI.AuthAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping(path = "/login")
    public ResponseEntity login(@RequestBody LoginDTO data) {
        try {
            Authentication authentication = userService.authenticateUser(data);
            return ResponseEntity.ok().build();
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping(path = "/register")
    public ResponseEntity register(@RequestBody RegisterDTO data) {
        try {
            userService.register(data);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body("Usuário já existe");
        }
    }

}


