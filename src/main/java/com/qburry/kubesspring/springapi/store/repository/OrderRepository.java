package com.qburry.kubesspring.springapi.store.repository;

import com.qburry.kubesspring.springapi.store.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
