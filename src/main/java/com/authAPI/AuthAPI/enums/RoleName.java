package com.authAPI.AuthAPI.enums;

public enum RoleName {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String role;

    RoleName(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
