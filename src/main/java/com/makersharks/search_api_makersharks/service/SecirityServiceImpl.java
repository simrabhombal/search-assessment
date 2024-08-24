package com.makersharks.search_api_makersharks.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;

import com.makersharks.search_api_makersharks.beans.User;
import com.makersharks.search_api_makersharks.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class SecirityServiceImpl implements SecurityService {
 
	@Autowired
	UserDetailsService  userDetailsService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	SecurityContextRepository securityContextRepo;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean longin(String username, String password,HttpServletRequest request, HttpServletResponse response) {
	UserDetails userDetails =	userDetailsService.loadUserByUsername(username);
	UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

		authenticationManager.authenticate(token);
		boolean result = token.isAuthenticated();
		if(result) {
			SecurityContext context =SecurityContextHolder.getContext();
			context.setAuthentication(token);
			securityContextRepo.saveContext(context, request, response);
		}
		
		return result;
	}

	@Override
	public User save(User user) {
		userRepository.save(user);
		return user;
	}
	

}
