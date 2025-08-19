package com.example.demo_thymeleaf.controller;

import com.example.demo_thymeleaf.dto.PageDTO;
import com.example.demo_thymeleaf.entity.Product;
import com.example.demo_thymeleaf.service.ProductService;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductService productService;

    @GetMapping("list-products")
    public String getAllProduct(@RequestParam(value = "keyword", required = false) String keyword,
                                Model model,
                                @PageableDefault(size = 10) Pageable pageable) {
        Page<Product> pProducts;

        if (keyword != null && !keyword.trim().isEmpty()) {
            pProducts = productService.searchProducts(keyword, pageable);
        } else {
            pProducts = productService.findAll(pageable);
        }

        PageDTO pageDTO = new PageDTO();
        pageDTO.setListDTO(pProducts.getContent());
        pageDTO.setPage(pProducts.getNumber());
        pageDTO.setTotalPage(pProducts.getTotalPages());
        pageDTO.setSize(pProducts.getSize());
        pageDTO.setNumElement(pProducts.getNumberOfElements());
        pageDTO.setTotalElement(pProducts.getTotalElements());
        pageDTO.setFirst(pProducts.isFirst());
        pageDTO.setLast(pProducts.isLast());
        model.addAttribute("pageDTO", pageDTO);
        model.addAttribute("keyword", keyword);
        return "ListProduct";
    }

    @GetMapping("/products/{id}")
    public String getProductDetail(@PathVariable int id, Model model) {
        Optional<Product> optionalProduct = productService.getProductById(id);

        if(optionalProduct.isEmpty()) {
            return "redirect:/products";
        }

        Product product = optionalProduct.get();
        model.addAttribute("product", product);
        return "ProductDetail";
    }
}
