package com.example.demo_thymeleaf.service;

import com.example.demo_thymeleaf.entity.Account;
import com.example.demo_thymeleaf.entity.Product;
import com.example.demo_thymeleaf.repository.ProductRepository;
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
public class ProductService {
    ProductRepository productRepository;

    public Page<Product> findAll(Pageable pageable) {
        Page<Product> pProducts = productRepository.findAll(pageable);
        return pProducts;
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Page<Product> searchProducts(String keyword, Pageable pageable) {
        Page<Product> pProducts = productRepository.findByProductNameContainingIgnoreCase(keyword, pageable);
        return pProducts;
    }

    public boolean save(Product product) {
        productRepository.save(product);
        return true;
    }

    public boolean update(Product product) {
        productRepository.save(product);
        return true;
    }

    public boolean delete(Product product) {
        productRepository.delete(product);
        return true;
    }
}

