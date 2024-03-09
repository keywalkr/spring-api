package com.qburry.kapi.ecom.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private UUID id;
    private Long userId;
    private LocalDateTime createdAt;
}
