package com.qburry.kapi.ecom.repository;

import com.qburry.kapi.ecom.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
