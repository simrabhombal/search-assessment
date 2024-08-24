package com.makersharks.search_api_makersharks.service;

import com.makersharks.search_api_makersharks.beans.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface SecurityService {

	boolean longin(String username, String password, HttpServletRequest request, HttpServletResponse response);
	
	public User save(User user);
}
