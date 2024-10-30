package com.ust.authentication_service.service;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ust.authentication_service.model.User;

public class CustomUserDetails implements UserDetails {

    private String name;
    private String password;
    private List<SimpleGrantedAuthority> allRoles;

    public CustomUserDetails(User user) {
        this.name = user.getUsername();
        this.password = user.getPassword();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }
}
