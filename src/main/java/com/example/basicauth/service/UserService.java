package com.example.basicauth.service;

import com.example.basicauth.dto.CreateUserRequest;
import com.example.basicauth.model.User;
import com.example.basicauth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User createUser(CreateUserRequest request) {
        User newUser = User.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .name(request.name())
                .authorities(request.authorities())
                .isEnabled(true)
                .accountNonExpired(true)
                .isAccountNonLocked(true)
                .credentialsNonExpired(true)
                .build();
        return userRepository.save(newUser);}
}
