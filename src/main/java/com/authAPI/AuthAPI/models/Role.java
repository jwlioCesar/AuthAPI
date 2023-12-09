package com.authAPI.AuthAPI.models;

import com.authAPI.AuthAPI.enums.RoleName;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public Role(Long id, RoleName roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    @Override
    public String getAuthority() {
        return roleName.name();
    }
}
