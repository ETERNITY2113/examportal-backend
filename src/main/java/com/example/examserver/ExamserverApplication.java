package com.example.examserver;

import com.example.examserver.exception.UserFoundException;
import com.example.examserver.model.Role;
import com.example.examserver.model.User;
import com.example.examserver.model.UserRole;
import com.example.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {

//		try {
//			User user = new User();
//			user.setFirstName("eternity");
//			user.setLastName("eternity");
//			user.setUsername("eternity");
//			user.setEmail("eternity@gmail.com");
//			user.setPassword(this.bCryptPasswordEncoder.encode("eternity"));
//			user.setProfile("default.png");
//			user.setPhone("9404985540");
//			Role role = new Role();
//			role.setRoleId(44L);
//			role.setRoleName("ROLE_ADMIN");
//			Role role1 = new Role();
//			role1.setRoleId(10L);
//			role1.setRoleName("ROLE_SUPER");
//			Set<UserRole> userRoleSet = new HashSet<>();
//			UserRole userRole = new UserRole();
//			userRole.setUser(user);
//			userRole.setRole(role);
//			UserRole userRole1 = new UserRole();
//			userRole1.setUser(user);
//			userRole1.setRole(role1);
//			userRoleSet.add(userRole1);
//			userRoleSet.add(userRole);
//			User user1 = this.userService.createUser(user, userRoleSet);
//		}
//		catch (UserFoundException  e)
//		{
//			e.printStackTrace();
//		}
	}
}
