package com.qburry.kubesspring.springapi.store.mapper;

import com.qburry.kubesspring.springapi.store.dto.Product;
import com.qburry.kubesspring.springapi.store.model.ProductEntity;
import org.mapstruct.Mapper;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {
    Product toProduct(ProductEntity entity);
    List<Product> toProducts(List<ProductEntity> entities);
    ProductEntity toEntity(Product product);
}
