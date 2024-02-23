package com.qburry.kubesspring.springapi.store.repository;

import com.qburry.kubesspring.springapi.store.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
