package com.example.demo_thymeleaf.controller;

import com.example.demo_thymeleaf.dto.PageDTO;
import com.example.demo_thymeleaf.entity.Category;
import com.example.demo_thymeleaf.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {
    CategoryService categoryService;

    @GetMapping("/category")
    public String getAllCategory(Model model,
                                 @PageableDefault(size = 5) Pageable pageable) {
        Page<Category> pCategories = categoryService.findAllCategory(pageable);
        PageDTO pageDTO = new PageDTO();
        pageDTO.setListDTO(pCategories.getContent());
        pageDTO.setPage(pCategories.getNumber());
        pageDTO.setTotalPage(pCategories.getTotalPages());
        pageDTO.setSize(pCategories.getSize());
        pageDTO.setNumElement(pCategories.getNumberOfElements());
        pageDTO.setTotalElement(pCategories.getTotalElements());
        pageDTO.setFirst(pCategories.isFirst());
        pageDTO.setLast(pCategories.isLast());
        model.addAttribute("pageDTO", pageDTO);
        return "ListCategory";
    }

    @GetMapping("/category-add")
    public String add() {
        return "CategoryAdd";
    }

    @PostMapping("/category-save")
    public String saveCategory(@RequestParam String categoryName,
                               @RequestParam String description) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setDescription(description);
        category.setCreatedDate(LocalDateTime.now());
        category.setUpdatedDate(LocalDateTime.now());

        categoryService.saveCategory(category);
        return "redirect:/category";
    }

    @GetMapping("category-edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Category category = categoryService.findCategoryById(id).get();
        model.addAttribute("category", category);
        return "CategoryEdit";
    }

    @PostMapping("category-edit/{id}")
    public String updateCategory(@PathVariable int id,
                                 @RequestParam String categoryName,
                                 @RequestParam String description,
                                 @RequestParam LocalDateTime createdDate) {
        Category category = categoryService.findCategoryById(id).get();
        category.setCategoryName(categoryName);
        category.setDescription(description);
        category.setCreatedDate(createdDate);
        category.setUpdatedDate(LocalDateTime.now());

        categoryService.updateCategory(category);
        return "redirect:/category";
    }

    @GetMapping("category-delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        Optional<Category> optionalCategory = categoryService.findCategoryById(id);

        if(optionalCategory.isEmpty()) {
            return "redirect:/category";
        }

        categoryService.deleteCategory(optionalCategory.get());
        return "redirect:/category";
    }
}
