package com.example.demo_thymeleaf.controller;

import com.example.demo_thymeleaf.entity.Product;
import com.example.demo_thymeleaf.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductService productService;

    @GetMapping("products")
    public String getAllProduct(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);

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
