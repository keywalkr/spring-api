package com.qburry.kapi.ecom.mapper;

import com.qburry.kapi.commons.MapperConfiguration;
import com.qburry.kapi.ecom.dto.Product;
import com.qburry.kapi.ecom.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", config = MapperConfiguration.class, uses = CategoryMapper.class)
public interface ProductMapper {

    @Mapping(target = "category.children", ignore = true)
    Product toProduct(ProductEntity entity);

    List<Product> toProducts(List<ProductEntity> entities);

    ProductEntity toEntity(Product product);
}
