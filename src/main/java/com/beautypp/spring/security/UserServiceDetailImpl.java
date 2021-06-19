package com.beautypp.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.beautypp.spring.model.User;
import com.beautypp.spring.repositories.UserRepository;

//@Service("userDetailsServiceImpl")
public class UserServiceDetailImpl implements UserDetailsService {

	private final UserRepository repository;

	@Autowired
	public UserServiceDetailImpl(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"));
        return UserSecurity.fromUser(user);
	}
	
	
	
}
