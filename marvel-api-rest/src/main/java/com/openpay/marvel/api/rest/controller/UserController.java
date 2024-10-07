package com.openpay.marvel.api.rest.controller;

import com.openpay.marvel.api.rest.model.entity.UserEntity;
import com.openpay.marvel.api.rest.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(userService.save(userEntity));
    }
}
