package com.example.demo_thymeleaf.service;

import com.example.demo_thymeleaf.entity.Category;
import com.example.demo_thymeleaf.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryService {
    CategoryRepository categoryRepository;

    public Page<Category> findAllCategory(Pageable pageable) {
        Page<Category> pCategories = categoryRepository.findAll(pageable);
        return pCategories;
    }

    public Optional<Category> findCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    public boolean saveCategory(Category category) {
        categoryRepository.save(category);
        return true;
    }

    public boolean updateCategory(Category category) {
        categoryRepository.save(category);
        return true;
    }

    public boolean deleteCategory(Category category) {
        categoryRepository.delete(category);
        return true;
    }
}
