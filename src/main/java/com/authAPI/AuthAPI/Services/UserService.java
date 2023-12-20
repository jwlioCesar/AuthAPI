package com.authAPI.AuthAPI.Services;

import com.authAPI.AuthAPI.dto.LoginDTO;
import com.authAPI.AuthAPI.dto.RegisterDTO;
import com.authAPI.AuthAPI.models.User;
import com.authAPI.AuthAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    public Authentication authenticateUser(LoginDTO loginDTO) throws AuthenticationException {
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.username(), loginDTO.password()));
    }

    @PostMapping(path = "/register")
    public void register(@RequestBody RegisterDTO data) {

        if (userRepository.findByUsername(data.username()) != null) {
            throw new RuntimeException("Usuário já existe");
        }
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            User newUser = new User(data.username(), encryptedPassword, data.role());

            userRepository.save(newUser);
        }
}




