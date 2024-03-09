package com.qburry.kapi.ecom.repository;

import com.qburry.kapi.ecom.model.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItemEntity, UUID> {
}
