package com.beautypp.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	private final UserDetailsService userDetailsService;
	
//	@Autowired
//	public WebSecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
//		this.userDetailsService = userDetailsService;
//	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		super.configure(http);
//	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		 http
//         .csrf().disable()
//         .authorizeRequests()
//         .antMatchers("/").permitAll()
//         .anyRequest()
//         .authenticated()
//         .and()
//         .formLogin()
//         .loginPage("/auth/login").permitAll()
//         .defaultSuccessUrl("/auth/success")
//         .and()
//         .logout()
//         .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
//         .invalidateHttpSession(true)
//         .clearAuthentication(true)
//         .deleteCookies("JSESSIONID")
//         .logoutSuccessUrl("/auth/login");
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("4").password(passwordEncoder().encode("4")).roles("USER");
	}
	
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		return new InMemoryUserDetailsManager(User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build());
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(daoAuthenticationProvider());
//	}
	
//	@Bean
//	protected DaoAuthenticationProvider daoAuthenticationProvider() {
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//		return daoAuthenticationProvider;
//	}
	
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}
}
