package com.qburry.kubesspring.springapi.store.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_items", uniqueConstraints = {@UniqueConstraint(columnNames = {"cart_id", "product_id"})})
public class CartItemEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private CartEntity cart;
    @OneToOne
    private ProductEntity product;
    private Double price;
    private Integer quantity;
}
