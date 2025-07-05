package com.data.business.dao;

import com.data.business.config.ConnectionDB;
import com.data.business.model.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

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



    public int delete(int id) {
        Connection conn = null;
        int countAffect = 0;
        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("{CALL delete_product_by_id(?)}");
            callSt.setInt(1, id);

            countAffect = callSt.executeUpdate();
            System.out.println("Xóa sản phẩm có id là " + id + " thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }

        return countAffect;
    }

//    public void addProduct(String nameNewProduct, int priceNewProduct, String brandNewProduct, int stockNewProduct) {
//        Connection conn = null;
//        int countAffect = 0;
//        try {
//            conn = ConnectionDB.openConn();
//            Statement st = conn.createStatement();
//
//            countAffect = st.executeUpdate("INSERT INTO products (product_name, product_price, brand, stock) values ('" + nameNewProduct +"', '" + priceNewProduct + "', '" + brandNewProduct + "', '" + stockNewProduct +"')");
//
//            if(countAffect > 0) {
//                System.out.println("Thêm sản phẩm thành công!");
//            }
//            else {
//                System.out.println("Thêm thất bại!");
//            }
//        } catch (Exception e) {
//            System.out.println("Lỗi lấy dữ liệu!");
//        }
//    }


    public int updateProduct(Product product) {
        Connection conn = null;
        int countAffect = 0;
        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("CALL update_product(?,?,?,?,?)");
            callSt.setInt(1, product.getId());
            callSt.setString(2, product.getProductName());
            callSt.setInt(3, product.getPrice());
            callSt.setString(4, product.getBrand());
            callSt.setInt(5, product.getStock());
            countAffect = callSt.executeUpdate();

            System.out.println("Cập nhật sản phẩm thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }
        return countAffect;
    }

    public int saveProduct(Product product) {
        Connection conn = null;
        int countAffect = 0;
        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("{CALL add_product(?,?,?,?)}");
            callSt.setString(1, product.getProductName());
            callSt.setInt(2, product.getPrice());
            callSt.setString(3, product.getBrand());
            callSt.setInt(4, product.getStock());
            countAffect = callSt.executeUpdate();

            System.out.println("Thêm sản phẩm thành công, tên sản phẩm: " + product.getProductName());
        }
        catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }
        return countAffect;
    }

    public List<Product> searchListProductByBrand(String brand_in) {
        Connection conn = null;
        List<Product> products = new ArrayList<>();

        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("CALL searchProductByBrand(?)");
            callSt.setString(1, brand_in);

            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                int price = rs.getInt("product_price");
                String brand = rs.getString("brand");
                int stock = rs.getInt("stock");

                Product product = new Product(id, productName, price, brand, stock);
                products.add(product);
            }
            else {
                System.out.println("Không có sản phẩm phù hợp với từ khoá");
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }

        return products;
    }


    public List<Product> searchListProductByPrice(double price_start, double price_end) {
        Connection conn = null;
        List<Product> products = new ArrayList<>();

        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("CALL searchProductByPrice(?,?)");
            callSt.setDouble(1, price_start);
            callSt.setDouble(2, price_end);

            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                int price = rs.getInt("product_price");
                String brand = rs.getString("brand");
                int stock = rs.getInt("stock");

                Product product = new Product(id, productName, price, brand, stock);
                products.add(product);
            }
            else {
                System.out.println("Không có sản phẩm phù hợp với từ khoá");
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }

        return products;
    }

    public List<Product> searchListProductByStock(int stock_in) {
        Connection conn = null;
        List<Product> products = new ArrayList<>();

        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("CALL searchProductByStock(?)");
            callSt.setInt(1, stock_in);

            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                int price = rs.getInt("product_price");
                String brand = rs.getString("brand");
                int stock = rs.getInt("stock");

                Product product = new Product(id, productName, price, brand, stock);
                products.add(product);
            }
            else {
                System.out.println("Không có sản phẩm phù hợp với từ khoá");
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }

        return products;
    }
}