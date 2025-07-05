package com.data.business.service;

import com.data.business.dao.ProductDAO;
import com.data.business.dao.ProductDAOImpl;
import com.data.business.model.Product;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO = new ProductDAOImpl();

    public List<Product> getListProduct() {
        return productDAO.getListProduct();
    }

    public void deleteProduct(int id) {
        productDAO.delete(id);
    }

    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    public void saveProduct(Product product) {
        productDAO.saveProduct(product);
    }

    public List<Product> searchByBrand(String brand_in) {
        return productDAO.searchListProductByBrand(brand_in);
    }

    public List<Product> searchByPriceRange(double price_start, double price_end) {
        return productDAO.searchListProductByPrice(price_start, price_end);
    }

    public List<Product> searchByStock(int stock_in) {
        return productDAO.searchListProductByStock(stock_in);
    }

    public void show(List<Product> products) {
        System.out.println("==== Danh sách sản phẩm ====");

        System.out.println("---------------------------------");
        System.out.println("|  Id  |  Product Name  |  Price  | Brand | Stock |");
        products.forEach(product -> {
            StringBuilder row = new StringBuilder();
            row.append("|  " + product.getId());
            row.append("|  " + product.getProductName());
            row.append("|  " + product.getPrice());
            row.append("|  " + product.getBrand());
            row.append("|  " + product.getStock() + "   |");

            System.out.println(row);
        });
        System.out.println("---------------------------------");

    }
}
