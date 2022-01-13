package com.andredias20.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andredias20.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	
	
}
