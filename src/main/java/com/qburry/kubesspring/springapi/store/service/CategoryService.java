package com.qburry.kubesspring.springapi.store.service;

import com.qburry.kubesspring.springapi.store.dto.Category;
import com.qburry.kubesspring.springapi.store.mapper.CategoryHierarchyMapper;
import com.qburry.kubesspring.springapi.store.mapper.CategoryMapper;
import com.qburry.kubesspring.springapi.store.model.CategoryEntity;
import com.qburry.kubesspring.springapi.store.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryService {

    private  final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CategoryHierarchyMapper categoryHierarchyMapper;

    public List<Category> findAll() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll().stream()
                .filter(c -> c.getParent() == null)
                .toList();
        return categoryHierarchyMapper.toCategories(categoryEntities);
    }
}
