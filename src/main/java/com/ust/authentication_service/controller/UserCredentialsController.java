package com.ust.authentication_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.authentication_service.model.User;
import com.ust.authentication_service.service.JwtService;
import com.ust.authentication_service.service.UserService;


@RestController
@RequestMapping("/api/auth")
public class UserCredentialsController {
    @Autowired
    JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/validate-token")
    public boolean validateToken(@RequestParam String token) {
        return userService.verifyToken(token);
    }

    @PostMapping("/login")
    public String getToken(@RequestBody User user) {
        System.out.println("user : " + user);
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        System.out.println("authenticated?? : " + authenticate.isAuthenticated());
        if(authenticate.isAuthenticated()) {
            return userService.generateToken(user.getUsername());
        }
        return null;
    }
}
