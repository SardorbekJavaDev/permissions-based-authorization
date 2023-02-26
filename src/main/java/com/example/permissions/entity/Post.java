package com.example.permissions.entity;

import com.example.permissions.entity.enums.Permission;
import com.example.permissions.entity.enums.RoleType;
import com.example.permissions.entity.template.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends AbstractEntity {
    @Column(nullable = false, columnDefinition = "text")
    private String title;
    @Column(nullable = false, columnDefinition = "text")
    private String text;
    @Column(nullable = false, columnDefinition = "text")
    private String url;
}