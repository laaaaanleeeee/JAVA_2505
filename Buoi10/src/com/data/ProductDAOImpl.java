package com.data;

import com.data.connection.ConnectionDB;
import com.data.model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl {

    public List<Product> getListProduct() {
        Connection conn = null;
        List<Product> products = new ArrayList<>();

        try {
            conn = ConnectionDB.openConn();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM products");
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                int price = rs.getInt("product_price");
                String brand = rs.getString("brand");
                int stock = rs.getInt("stock");

                Product product = new Product(id, productName, price, brand, stock);
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }

        return products;
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

    public int delete(int id) {
        Connection conn = null;
        int countAffect = 0;
        try {
            conn = ConnectionDB.openConn();
            Statement st = conn.createStatement();

            countAffect = st.executeUpdate("DELETE FROM products WHERE product_id = " + id);
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }

        return countAffect;
    }

    public void addProduct(String nameNewProduct, int priceNewProduct, String brandNewProduct, int stockNewProduct) {
        Connection conn = null;
        int countAffect = 0;
        try {
            conn = ConnectionDB.openConn();
            Statement st = conn.createStatement();

            countAffect = st.executeUpdate("INSERT INTO products (product_name, product_price, brand, stock) values ('" + nameNewProduct +"', '" + priceNewProduct + "', '" + brandNewProduct + "', '" + stockNewProduct +"')");

            if(countAffect > 0) {
                System.out.println("Thêm sản phẩm thành công!");
            }
            else {
                System.out.println("Thêm thất bại!");
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }
    }


    public void updateProduct(int id,String nameNewProduct, int priceNewProduct, String brandNewProduct, int stockNewProduct) {
        Connection conn = null;
        int countAffect = 0;
        try {
            conn = ConnectionDB.openConn();
            Statement st = conn.createStatement();

            countAffect = st.executeUpdate("UPDATE products SET product_name = '"+ nameNewProduct +"', product_price = '" + priceNewProduct + "', brand = '" + brandNewProduct + "', stock = '" + stockNewProduct +"' WHERE product_id = '" + id + "'");

            if(countAffect > 0) {
                System.out.println("Cập nhật sản phẩm thành công");
            }
            else {
                System.out.println("Cập nhật thất bại");
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }
    }
}