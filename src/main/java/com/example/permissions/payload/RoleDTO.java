package com.example.permissions.payload;

import com.example.permissions.entity.enums.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    @NotBlank(message = "FullName can not be empty !")
    private String name;

    private String description;
    @NotEmpty
    private List<Permission> permissionList;

}
