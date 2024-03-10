package com.qburry.kapi.ecom.repository;

import com.qburry.kapi.ecom.model.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CartRepository extends JpaRepository<CartEntity, UUID> {

    @Query("select c from CartEntity c where c.user.id = ?1")
    CartEntity findCartEntityByUser(Long userId);
}
