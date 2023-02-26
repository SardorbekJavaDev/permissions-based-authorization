package com.example.permissions.controller;

import com.example.permissions.payload.ApiResponse;
import com.example.permissions.payload.RegisterDTO;
import com.example.permissions.payload.UserDTO;
import com.example.permissions.service.AuthService;
import com.example.permissions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/add")
    public HttpEntity<?> register(@Valid @RequestBody UserDTO userDTO){
        ApiResponse apiResponse = userService.addUser(userDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
