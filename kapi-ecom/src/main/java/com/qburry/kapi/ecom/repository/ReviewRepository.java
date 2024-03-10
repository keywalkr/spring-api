package com.qburry.kapi.ecom.repository;

import com.qburry.kapi.ecom.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
