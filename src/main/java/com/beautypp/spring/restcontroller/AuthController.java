package com.beautypp.spring.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beautypp.spring.model.User;
import com.beautypp.spring.repositories.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;

	    @GetMapping("/login")
	    public List<User> getLoginPage() {
	        return userRepository.findAll();
	    }

	    @GetMapping("/success")
	    public String getSuccessPage() {
	        return "success";
	    }
	
}
