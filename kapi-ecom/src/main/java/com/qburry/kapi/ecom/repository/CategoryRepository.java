package com.qburry.kapi.ecom.repository;

import com.qburry.kapi.ecom.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
