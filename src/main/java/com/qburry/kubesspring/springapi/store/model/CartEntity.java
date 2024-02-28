package com.qburry.kubesspring.springapi.store.model;

import com.qburry.kubesspring.springapi.user.model.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
public class CartEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @OneToOne
    private UserEntity user;
    private String status;

    @OneToMany(mappedBy = "cart")
    private Set<CartItemEntity> cartItems;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
}
