package com.qburry.kapi.ecom.mapper;

import com.qburry.kapi.ecom.dto.Category;
import com.qburry.kapi.ecom.model.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryHierarchyMapper {

    @Mapping(target = "parent", ignore = true)
    Category toCategory(CategoryEntity entity);

    List<Category> toCategories (List<CategoryEntity> entities);
}
