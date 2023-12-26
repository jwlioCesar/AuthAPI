package com.authAPI.AuthAPI.controllers;

import com.authAPI.AuthAPI.Services.UserService;
import com.authAPI.AuthAPI.config.jwt.TokenService;
import com.authAPI.AuthAPI.dto.LoginDTO;
import com.authAPI.AuthAPI.dto.RegisterDTO;
import com.authAPI.AuthAPI.dto.TokenDTO;
import com.authAPI.AuthAPI.models.User;
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

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private UserService userService;
    private TokenService tokenService;

    @Autowired
    public UserController(AuthenticationManager authenticationManager, UserRepository userRepository, UserService userService, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @Autowired



    @PostMapping(path = "/login")
    public ResponseEntity login(@RequestBody LoginDTO data) {
        try {
            Authentication authentication = userService.authenticateUser(data);

            var token = tokenService.generateToken((User)authentication.getPrincipal());

            return ResponseEntity.ok(new TokenDTO(token));
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


