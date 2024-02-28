package com.qburry.kubesspring.springapi.store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_lines")
public class OrderLinesEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    private OrderEntity order;
    @ManyToOne
    private ProductEntity product;
    private Double price;
    private Integer quantity;
}
