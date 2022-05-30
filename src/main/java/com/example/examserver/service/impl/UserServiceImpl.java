package com.example.examserver.service.impl;

import java.util.Set;

import com.example.examserver.exception.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examserver.model.User;
import com.example.examserver.model.UserRole;
import com.example.examserver.repository.RoleRepository;
import com.example.examserver.repository.UserRepository;
import com.example.examserver.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	 
	@Autowired
    private	UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local = this.userRepository.findByUsername(user.getUsername());		
		if(local!=null)
		{
			System.out.println("User is already there !!");
			throw new UserFoundException();
		}
		else {
			for (UserRole ur: userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
			
		}
		
		return local;
	}

	
	//getting user by username
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}


	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}
	

}
