package com.data.presentation;

import com.data.business.model.Product;
import com.data.business.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductMenu {
    public static void chooseMenuProduct() {
        ProductService productService = new ProductService();

        System.out.print("Nhập lựa chọn: ");
        Scanner sc = new Scanner(System.in);
        int numChucNang = sc.nextInt();

        while (numChucNang < 1 || numChucNang > 8) {
            System.out.println("Số chức năng chưa đúng!. Vui lòng nhập lại:");
            numChucNang = sc.nextInt();
        }
        if (numChucNang == 8) {
            MainMenu.showMenu();
        }
        else if (numChucNang == 1) {
            System.out.println("**** Chức năng xem danh sách sản phẩm");
            List<Product> products = productService.getListProduct();
            productService.show(products);
            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuProduct.showMenuProduct();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }

        }
        else if (numChucNang == 4) {
            // hiển thị danh sách để chọn id
            List<Product> products = productService.getListProduct();
            productService.show(products);

            System.out.println("**** Chức năng xóa sản phẩm theo ID");
            System.out.print("Nhập id điện thoại cần xoá: ");
            int id = 0;
            sc = new Scanner(System.in);
            id = sc.nextInt();

            productService.deleteProduct(id);

            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuProduct.showMenuProduct();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }

        }
        else if (numChucNang == 2) {
            System.out.println("==== Nhập tên sản phẩm:");
            sc = new Scanner(System.in);
            String productName = sc.nextLine();

            System.out.println("==== Nhập giá tiền:");
            int price = sc.nextInt();

            System.out.println("==== Nhập tên thương hiệu:");
            sc = new Scanner(System.in);
            String brand = sc.nextLine();

            System.out.println("==== Nhập tồn kho:");
            int stock = sc.nextInt();

            Product product = new Product(0,  productName, price, brand, stock);
            productService.saveProduct(product);

            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuProduct.showMenuProduct();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }
        }

        else if(numChucNang == 3) {
            System.out.println("**** Chức năng cập nhật sản phẩm");
            List<Product> products = productService.getListProduct();
            productService.show(products);

            System.out.println("**** Chức năng cập nhật sản phẩm theo ID");
            System.out.print("Nhập id sản phẩm cần cập nhật: ");
            sc = new Scanner(System.in);
            int id = sc.nextInt();
            System.out.print("Nhập tên sản phẩm mới: ");
            sc = new Scanner(System.in);
            String nameNewProduct = sc.nextLine();
            System.out.print("Nhập giá sản phẩm mới: ");
            sc = new Scanner(System.in);
            int priceNewProduct = sc.nextInt();
            System.out.print("Nhập tên thương hiệu sản phẩm mới: ");
            sc = new Scanner(System.in);
            String brandNewProduct = sc.nextLine();
            System.out.print("Nhập số lượng tồn kho sản phẩm mới: ");
            sc = new Scanner(System.in);
            int stockNewProduct = sc.nextInt();

            Product product = new Product(id,  nameNewProduct, priceNewProduct, brandNewProduct, stockNewProduct);
            productService.updateProduct(product);
            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuProduct.showMenuProduct();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }
        }
        else if(numChucNang == 5) {
            sc = new Scanner(System.in);
            System.out.print("Nhập vào từ khoá brand bạn muốn tìm kiếm: ");
            String tuKhoa = sc.nextLine();

            List<Product> products = productService.searchByBrand(tuKhoa);
            productService.show(products);

            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuProduct.showMenuProduct();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }
        }

        else if(numChucNang == 6) {
            sc = new Scanner(System.in);
            System.out.println("Nhập vào khoảng giá sản phẩm bạn muốn tìm kiếm!");
            System.out.print("Nhập vào khoảng giá tối thiểu: ");
            double price_start = sc.nextDouble();
            System.out.print("Nhập vào khoảng giá tối đa: ");
            double price_end = sc.nextDouble();

            List<Product> products = productService.searchByPriceRange(price_start, price_end);
            productService.show(products);

            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuProduct.showMenuProduct();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }
        }

        else if(numChucNang == 7) {
            sc = new Scanner(System.in);
            System.out.print("Nhập vào số lượng tồn kho bạn muốn tìm kiếm: ");
            int stock_in = sc.nextInt();

            List<Product> products = productService.searchByStock(stock_in);
            productService.show(products);

            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuProduct.showMenuProduct();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }
        }
    }
}
