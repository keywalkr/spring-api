package com.qburry.kubesspring.springapi.store.dto;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private UUID id;
    private Long userId;
    private String status;
    private Set<CartItem> cartItems;
}
