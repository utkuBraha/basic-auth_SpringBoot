package com.example.basicauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/private")
public class PrivateController {

        @GetMapping
        public String getPrivate() {
            return "Hello from private controller";
        }
    @GetMapping("/admin")
    public String getAdmin() {
        return "Hello from admin controller";
    }
    @GetMapping("/user")
    public String getUser() {
        return "Hello from user controller";
    }
}
