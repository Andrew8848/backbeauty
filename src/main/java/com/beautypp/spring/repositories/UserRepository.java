package com.beautypp.spring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beautypp.spring.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);

}
