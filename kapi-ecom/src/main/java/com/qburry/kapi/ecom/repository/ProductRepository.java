package com.qburry.kapi.ecom.repository;

import com.qburry.kapi.ecom.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
