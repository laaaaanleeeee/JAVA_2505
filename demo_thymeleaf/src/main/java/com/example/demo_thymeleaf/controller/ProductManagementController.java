package com.example.demo_thymeleaf.controller;

import com.example.demo_thymeleaf.dto.PageDTO;
import com.example.demo_thymeleaf.entity.Account;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductManagementController {
    ProductService productService;

    @GetMapping("product-management")
    public String findAllProducts(Model model, @PageableDefault(size = 10) Pageable pageable) {
        Page<Product> pProducts = productService.findAll(pageable);
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
        return "ProductManagement";
    }

    @GetMapping("product-delete/{id}")
    public String delete(@PathVariable int id) {
        Optional<Product> optionalProduct = productService.getProductById(id);

        if(optionalProduct.isEmpty()) {
            return "redirect:/account-list";
        }

        productService.delete(optionalProduct.get());
        return "redirect:/product-management";
    }

    @GetMapping("product-add")
    public String add() {
        return "ProductAdd";
    }

    @PostMapping("product-save")
    public String save(@RequestParam String productName,
                       @RequestParam BigDecimal price,
                       @RequestParam String brand,
                       @RequestParam int quantity,
                       @RequestParam String status) {
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setBrand(brand);
        product.setQuantity(quantity);
        product.setStatus(status);
        product.setCreatedDate(LocalDateTime.now());
        product.setUpdatedDate(LocalDateTime.now());

        productService.save(product);
        return "redirect:/product-management";
    }

    @GetMapping("product-edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id).get();
        model.addAttribute("product", product);
        return "ProductEdit";
    }

    @PostMapping("product-edit/{id}")
    public String save(@PathVariable int id,
                       @RequestParam String productName,
                       @RequestParam BigDecimal price,
                       @RequestParam String brand,
                       @RequestParam int quantity,
                       @RequestParam String status,
                       @RequestParam LocalDateTime createdDate) {
        Product product = productService.getProductById(id).get();
        product.setProductName(productName);
        product.setPrice(price);
        product.setBrand(brand);
        product.setQuantity(quantity);
        product.setStatus(status);
        product.setCreatedDate(createdDate);
        product.setUpdatedDate(LocalDateTime.now());

        productService.update(product);
        return "redirect:/product-management";
    }
}
