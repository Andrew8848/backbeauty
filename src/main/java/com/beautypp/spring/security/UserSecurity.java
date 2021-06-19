package com.beautypp.spring.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.beautypp.spring.model.Status;
import com.beautypp.spring.model.User;

import lombok.Data;

public class UserSecurity implements UserDetails{

	private final String username;
	private final String password;
	private final List<SimpleGrantedAuthority> authorities; 
	private final boolean isActive;
		
	public UserSecurity(String username, String password, List<SimpleGrantedAuthority> authorities, boolean isActive) {
		super();
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.isActive = isActive;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return isActive;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return isActive;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return isActive;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isActive;
	}
	
	public static UserDetails fromUser(User user) {
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), user.getPassword(), 
				user.getStatus().equals(Status.ACTIVE),
				user.getStatus().equals(Status.ACTIVE),
				user.getStatus().equals(Status.ACTIVE),
				user.getStatus().equals(Status.ACTIVE),
				user.getRole().getAuthorities()
				);
	}

	public boolean isActive() {
		return isActive;
	}
	
}
