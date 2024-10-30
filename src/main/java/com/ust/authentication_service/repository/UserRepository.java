package com.ust.authentication_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.authentication_service.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    public Optional<User> findByUsername(String name);
}