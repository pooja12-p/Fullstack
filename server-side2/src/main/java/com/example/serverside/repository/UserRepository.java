package com.example.serverside.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.serverside.model.PujaUser;

public interface UserRepository extends JpaRepository<PujaUser, Long> {
	  
	PujaUser findByUsername(String username);

}
