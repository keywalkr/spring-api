package com.qburry.kubesspring.springapi.store.dto;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private UUID id;
    private UUID cartId;
    private Long productId;
    private Double price;
    private Integer quantity;
}
