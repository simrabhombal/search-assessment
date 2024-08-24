package com.makersharks.search_api_makersharks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.makersharks.search_api_makersharks.beans.User;


public interface UserRepository extends JpaRepository<User, Integer> {

//	User findByusername(String username);
	 
	User findByemail(String email);



}
