package com.ust.authentication_service.service;

import java.util.Optional;

import com.ust.authentication_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ust.authentication_service.repository.UserRepository;
import com.ust.authentication_service.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);
        System.out.println("user 2: " + user);
        return user.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("Username/password not valid!"));
    }
}