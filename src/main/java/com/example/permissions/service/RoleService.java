package com.example.permissions.service;

import com.example.permissions.entity.Role;
import com.example.permissions.entity.enums.RoleType;
import com.example.permissions.payload.ApiResponse;
import com.example.permissions.payload.RoleDTO;
import com.example.permissions.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public ApiResponse addRole(RoleDTO roleDTO) {
        if (roleRepository.existsByName(roleDTO.getName()))
            return new ApiResponse("Role with name " + roleDTO.getName() + " already exists !", false);
        Role role = new Role(
                roleDTO.getName(),
                RoleType.ROLE_CUSTOM,
                roleDTO.getPermissionList(),
                roleDTO.getDescription()
        );
        roleRepository.save(role);
        return new ApiResponse("Role has been created !", true);
    }

    public ApiResponse editRole(RoleDTO roleDTO) {
        return null;
    }
}
