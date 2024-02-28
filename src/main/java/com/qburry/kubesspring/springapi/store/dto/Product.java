package com.qburry.kubesspring.springapi.store.dto;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String picture;
    private String summary;
    private String description;
    private double price;
    private Category category;
}
