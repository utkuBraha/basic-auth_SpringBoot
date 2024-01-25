package com.example.basicauth;

import com.example.basicauth.dto.CreateUserRequest;
import com.example.basicauth.model.Role;
import com.example.basicauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

	private final UserService userService;

	public BasicAuthApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createUsers();
	}
	private void createUsers() {
		CreateUserRequest admin = CreateUserRequest.builder()
				.username("admin")
				.password("pass")
				.name("Admin")
				.authorities(Set.of(Role.ROLE_ADMIN))
				.build();
		userService.createUser(admin);
		CreateUserRequest user = CreateUserRequest.builder()
				.username("user")
				.password("pass")
				.name("User")
				.authorities(Set.of(Role.ROLE_USER))
				.build();
		userService.createUser(user);
	}
}
