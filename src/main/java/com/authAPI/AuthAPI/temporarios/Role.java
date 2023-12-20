//package com.authAPI.AuthAPI.models;
//
//import com.authAPI.AuthAPI.enums.RoleName;
//import jakarta.persistence.*;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.UUID;
//
//@Entity
//public class Role implements GrantedAuthority {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private UUID id;
//
//    @Enumerated(EnumType.STRING)
//    private RoleName roleName;
//
//    public Role(UUID id, RoleName roleName) {
//        this.id = id;
//        this.roleName = roleName;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public RoleName getRoleName() {
//        return roleName;
//    }
//
//    @Override
//    public String getAuthority() {
//        return roleName.name();
//    }
//}
