package com.example.basicauth.dto;


import com.example.basicauth.model.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateUserRequest (
        String username,
        String password,
        String name,
        Set<Role> authorities
) {

}
