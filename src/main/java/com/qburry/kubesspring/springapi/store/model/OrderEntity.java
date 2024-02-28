package com.qburry.kubesspring.springapi.store.model;

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

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class OrderEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    private UserEntity user;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
