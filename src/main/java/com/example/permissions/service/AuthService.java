package com.example.permissions.service;

import com.example.permissions.entity.User;
import com.example.permissions.exception.ResourceNotFoundException;
import com.example.permissions.payload.ApiResponse;
import com.example.permissions.payload.RegisterDTO;
import com.example.permissions.repository.RoleRepository;
import com.example.permissions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public ApiResponse registerUser(RegisterDTO dto) {

        if (!dto.getPassword().equals(dto.getPrePassword())) {
            return new ApiResponse("Password and pre password not equal !", false);
        }

        if (userRepository.existsByUsername(dto.getUsername())) {
            return new ApiResponse("User already exists !", false);
        }


        User user = new User(
                dto.getFullName(),
                dto.getUsername(),
                passwordEncoder.encode(dto.getPassword()),
                roleRepository.findByName("User").orElseThrow(() -> {
                    throw new ResourceNotFoundException("Role", "name", "user");
                }),
                true
        );

        userRepository.save(user);
        return new ApiResponse("", true);
    }

    public UserDetails loadUserByUsername(String userName) {
        return userRepository.findByUsername(userName).orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found !");
        });
    }
}
