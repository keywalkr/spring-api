package com.qburry.kapi.ecom.mapper;

import com.qburry.kapi.ecom.dto.Category;
import com.qburry.kapi.ecom.model.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryEntity entity);

    List<Category> toCategories(List<CategoryEntity> entities);


    CategoryEntity toEntity(Category category);
}
