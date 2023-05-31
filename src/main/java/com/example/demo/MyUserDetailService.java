package com.example.demo;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//UserDetails user =
			//  User.withDefaultPasswordEncoder()
			// 	.username("user")
			// 	.password("passwd")
			// 	.roles("USER")
			// 	.build();
		UserDetails user =
			 User.builder()
				.username("user")
				.password("passwd")
				.roles("USER")
				.build();

		return user;		
	}

}