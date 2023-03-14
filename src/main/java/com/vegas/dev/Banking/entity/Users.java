package com.vegas.dev.Banking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nom", length = 255, nullable = false)
    private String name;
    @Column(name = "email", length = 255, nullable = false)
    private String email;
    @Column(name = "password", length = 255, nullable = false)
    private String password;
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Column(name = "updateAt")
    private Timestamp updateAt;
    @Column(name = "createdBy", length = 255, nullable = false)
    private String createdBy;
    @Column(name = "updatedBy", length = 255, nullable = false)
    private String updatedBy;

    @Column(name = "role", length = 255)
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
