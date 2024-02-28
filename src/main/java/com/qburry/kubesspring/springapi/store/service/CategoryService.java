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

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CategoryHierarchyMapper categoryHierarchyMapper;

    public List<Category> findAll() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll().stream()
                .filter(c -> c.getParent() == null)
                .toList();
        return categoryHierarchyMapper.toCategories(categoryEntities);
    }

    public Long saveNewCategory(Category category) {
        CategoryEntity entity = categoryMapper.toEntity(category);
        return categoryRepository.save(entity).getId();
    }

    public void updateCategory(Category category) {
        CategoryEntity entity = categoryMapper.toEntity(category);
        if (entity.getParent() == null) {
            categoryRepository.findById(category.getId())
                    .ifPresentOrElse(c -> entity.setParent(c.getParent()),
                            () -> {
                                log.info("Error while trying to update category {}", entity.getId());
                                throw new RuntimeException("supplier not found");
                            });
        }
        categoryRepository.save(entity);
    }
}
