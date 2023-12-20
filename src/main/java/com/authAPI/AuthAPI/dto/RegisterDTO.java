package com.authAPI.AuthAPI.dto;

import com.authAPI.AuthAPI.enums.RoleName;

public record RegisterDTO(String username, String password, RoleName role) {
}
