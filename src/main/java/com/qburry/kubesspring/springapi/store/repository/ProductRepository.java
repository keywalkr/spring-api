package com.qburry.kubesspring.springapi.store.repository;

import com.qburry.kubesspring.springapi.store.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
