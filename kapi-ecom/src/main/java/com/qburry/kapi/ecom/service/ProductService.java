package com.qburry.kapi.ecom.service;

import com.qburry.kapi.ecom.dto.Product;
import com.qburry.kapi.ecom.mapper.ProductMapper;
import com.qburry.kapi.ecom.model.ProductEntity;
import com.qburry.kapi.ecom.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<Product> findAllProduct() {
        List<ProductEntity> entities = productRepository.findAll();
        return productMapper.toProducts(entities);
    }
}
