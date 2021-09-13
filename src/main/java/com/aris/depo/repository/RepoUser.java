package com.aris.depo.repository;

import com.aris.depo.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RepoUser extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);


}