package com.authAPI.AuthAPI.controllers;

import com.authAPI.AuthAPI.Services.UserService;
import com.authAPI.AuthAPI.dto.request.UserRequestLoginDTO;
import com.authAPI.AuthAPI.dto.response.UserResponseLoginDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/login")
    public ResponseEntity<UserResponseLoginDTO> login(@RequestBody UserRequestLoginDTO data){
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(data));
    }

}
