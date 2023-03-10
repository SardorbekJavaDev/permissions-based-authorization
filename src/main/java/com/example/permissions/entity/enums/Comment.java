package com.example.permissions.entity.enums;

import com.example.permissions.entity.Post;
import com.example.permissions.entity.template.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment extends AbstractEntity {
    @Column(nullable = false, columnDefinition = "text")
    private String text;
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
}