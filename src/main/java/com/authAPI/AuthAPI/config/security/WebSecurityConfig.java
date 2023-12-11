package com.authAPI.AuthAPI.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{

        http.csrf(csrf -> csrf.disable());
        //define que a autenticacao vai ser stateless
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.authorizeHttpRequests(authorization -> authorization
                .requestMatchers(HttpMethod.POST, "/product").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/product/**").hasRole("ADMIN")
                .anyRequest().authenticated());

        return http.build();
    }

}
