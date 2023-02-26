package com.example.permissions.controller;

import com.example.permissions.payload.ApiResponse;
import com.example.permissions.payload.RoleDTO;
import com.example.permissions.payload.UserDTO;
import com.example.permissions.service.RoleService;
import com.example.permissions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PreAuthorize(value = "hasAuthority('ADD_ROLE')")
    @PostMapping("/add")
    public HttpEntity<?> addRole(@Valid @RequestBody RoleDTO roleDTO){
        ApiResponse apiResponse = roleService.addRole(roleDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PreAuthorize(value = "hasAuthority('EDIT_ROLE')")
    @PutMapping("/{id}")
    public HttpEntity<?> editRole(@Valid @RequestBody RoleDTO roleDTO, @PathVariable Long id){
        ApiResponse apiResponse = roleService.editRole(roleDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
