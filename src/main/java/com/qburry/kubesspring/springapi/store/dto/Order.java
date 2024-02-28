package com.qburry.kubesspring.springapi.store.dto;

import com.qburry.kubesspring.springapi.user.model.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

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
