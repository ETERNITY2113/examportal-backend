package com.example.examserver.service.impl;

import com.example.examserver.model.exam.BulkCategoryRequest;
import com.example.examserver.model.exam.Category;
import com.example.examserver.repository.CategoryRepository;
import com.example.examserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<Category> addBulkCategories(BulkCategoryRequest bulkCategoryRequest) {

        List<Category> categoryList = new ArrayList<>();

        bulkCategoryRequest.getCategories().forEach(each ->{
            Category category = new Category();
            category.setTitle(each.getTitle());
            category.setDescription(each.getDescription());

            categoryList.add(category);
        });
        return this.categoryRepository.saveAll(categoryList);
    }
}
