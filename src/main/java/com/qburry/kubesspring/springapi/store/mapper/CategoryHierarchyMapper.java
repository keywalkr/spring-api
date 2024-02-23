package com.qburry.kubesspring.springapi.store.mapper;

import com.qburry.kubesspring.springapi.store.dto.Category;
import com.qburry.kubesspring.springapi.store.model.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryHierarchyMapper {

    @Mapping(target = "parent", ignore = true)
    Category toCategory(CategoryEntity entity);

    List<Category> toCategories (List<CategoryEntity> entities);
}
