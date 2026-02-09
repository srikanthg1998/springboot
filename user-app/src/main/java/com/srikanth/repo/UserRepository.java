package com.srikanth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srikanth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
