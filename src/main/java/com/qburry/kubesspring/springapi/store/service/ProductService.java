package com.qburry.kubesspring.springapi.store.service;

import com.qburry.kubesspring.springapi.store.dto.Product;
import com.qburry.kubesspring.springapi.store.mapper.ProductMapper;
import com.qburry.kubesspring.springapi.store.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<Product> findAllProduct() {
        return productMapper.toProducts(productRepository.findAll());
    }
}
