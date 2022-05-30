package com.example.examserver.service;

import java.util.Set;

import com.example.examserver.model.User;
import com.example.examserver.model.UserRole;

public interface UserService {

	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	public User getUser(String username); 
	
	public void deleteUser(Long userID); 
	
	
}
