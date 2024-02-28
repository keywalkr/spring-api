package com.qburry.kubesspring.springapi.store.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Long id;
    private String name;
    private String description;
    private Set<Category> children;
    private Category parent;
}
