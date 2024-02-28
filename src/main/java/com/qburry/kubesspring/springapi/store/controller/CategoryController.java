package com.qburry.kubesspring.springapi.store.controller;

import com.qburry.kubesspring.springapi.store.dto.Category;
import com.qburry.kubesspring.springapi.store.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/store/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/list")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping("/add")
    public Long createCategory(@RequestBody Category category){
        return categoryService.saveNewCategory(category);
    }

    @PutMapping("/update/{id}")
    public void updateCategory(@RequestBody Category category, @PathVariable("id") Long id) {
        if(id != null && id.equals(category.getId())){
            categoryService.updateCategory(category);
        }
    }
}
