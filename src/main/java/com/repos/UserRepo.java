package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
