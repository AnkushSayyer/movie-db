package com.example.demo.auth;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class ApplicationUserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", username)));

		Set<SimpleGrantedAuthority> authorities = user.getUserRole().getGrantedAuthorities();
		return new ApplicationUser(authorities, user.getUsername(), user.getPassword(), true, true, true, true);
	}

}
