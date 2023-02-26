package com.example.permissions.entity;

import com.example.permissions.entity.enums.Permission;
import com.example.permissions.entity.enums.RoleType;
import com.example.permissions.entity.template.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role extends AbstractEntity {
    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Permission> permissionList;
    @Column(length = 500)
    private String description;
}
