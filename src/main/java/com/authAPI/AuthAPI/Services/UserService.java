package com.authAPI.AuthAPI.Services;

import com.authAPI.AuthAPI.dto.request.UserRequestLoginDTO;
import com.authAPI.AuthAPI.dto.response.UserResponseLoginDTO;
import com.authAPI.AuthAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private AuthenticationManager manager;


    public UserResponseLoginDTO login(UserRequestLoginDTO data){
        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(
                data.username(), data.password()));

        return
    }

}
