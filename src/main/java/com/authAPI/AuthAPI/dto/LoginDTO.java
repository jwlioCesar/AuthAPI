package com.authAPI.AuthAPI.dto;

public record LoginDTO(String username, String password) {

    @Override
    public String username() {
        return username;
    }

    @Override
    public String password() {
        return password;
    }

}
