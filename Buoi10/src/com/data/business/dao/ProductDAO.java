package com.data.business.dao;

import com.data.business.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getListProduct();
    int delete(int id);
    int updateProduct(Product product);
    int saveProduct(Product product);
    List<Product> searchListProductByBrand(String brand_in);
    List<Product> searchListProductByPrice(double price_start, double price_end);
    List<Product> searchListProductByStock(int stock_in);

}
