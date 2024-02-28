package com.qburry.kubesspring.springapi.store.repository;

import com.qburry.kubesspring.springapi.store.model.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItemEntity, UUID> {
}
