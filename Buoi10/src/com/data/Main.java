package com.data;

import com.data.connection.ConnectionDB;
import com.data.model.Product;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        chooseOption();
    }


    private static void chooseOption() {
        System.out.println("==== HỆ THỐNG QUẢN LÝ CỬA HÀNG ====");
        System.out.println("1. Đăng nhập Admin");
        System.out.println("2. Thoát");
        System.out.println("===================================");

        System.out.print("Nhập lựa chọn: ");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        while (option < 1 || option > 2) {
            System.out.print("Số chức năng chưa đúng!. Vui lòng nhập lại (1-2): ");
            option = sc.nextInt();
        }

        switch (option) {
            case 1:
                showMenuLogin();
            default:
                System.exit(0);
        }
    }

    private static void showMenuLogin() {
        AccountDAOImpl accountDAO = new AccountDAOImpl();

        System.out.println("==== ĐĂNG NHẬP QUẢN TRỊ ====");
        System.out.print("Tài khoản: ");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        System.out.print("Mật khẩu: ");
        String pass = sc.nextLine();

        while (!accountDAO.getAccount(userName,pass)) {
            System.out.println("Tài khoản hoặc mật khẩu sai. Yêu cầu nhập lại!");
            System.out.print("Tài khoản: ");
            userName = sc.nextLine();
            System.out.print("Mật khẩu: ");
            pass = sc.nextLine();
        }
        showMenu();
    }

    private static void showMenu() {
        ProductDAOImpl productDAO = new ProductDAOImpl();

        // thực hành tạo menu
        System.out.println("==== MENU CHÍNH ====");
        System.out.println("1. Quản lý sản phẩm điện thoại");
        System.out.println("2. Quản lý khách hàng");
        System.out.println("3. Quản lý hoá đơn");
        System.out.println("4. Thống kê doanh thu");
        System.out.println("5. Đăng xuất");
        System.out.println("====================");

        System.out.print("Nhập lựa chọn: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n < 1 || n > 5) {
            System.out.println("Số chức năng chưa đúng!. Vui lòng nhập lại:");
            n = sc.nextInt();
        }

        switch (n) {
            case 1:
                System.out.println("==== Chức năng Quản lý điện thoại ====");
                showMenuProduct();
                break;
            case 2:
                System.out.println("==== Chức năng Quản lý khách hàng ====");
                break;
            case 3:
                System.out.println("==== Chức năng Quản lý hoá đơn ====");
                break;
            case 4:
                System.out.println("==== Chức năng Quản lý doanh thu ====");
                break;
            default:
                System.out.println("=======================================================");
                System.out.print("Bạn có chắc là muốn đăng xuất (Yes/No)? ");
                sc = new Scanner(System.in);
                String conti = sc.nextLine();
                if(conti.equals("Yes")) {
                    chooseOption();
                }
                else if (conti.equals("No")) {
                    showMenu();
                }
        }
    }



    private static void chooseMenuProduct() {
        ProductDAOImpl productDAO = new ProductDAOImpl();

        System.out.print("Nhập lựa chọn: ");
        Scanner sc = new Scanner(System.in);
        int numChucNang = sc.nextInt();

        while (numChucNang < 1 || numChucNang > 8) {
            System.out.println("Số chức năng chưa đúng!. Vui lòng nhập lại:");
            numChucNang = sc.nextInt();
        }
        if (numChucNang == 8) {
            showMenu();
        }
        else if (numChucNang == 1) {
            System.out.println("**** Chức năng xem danh sách sản phẩm");
            List<Product> products = productDAO.getListProduct();
            productDAO.show(products);
            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.equals("Yes")) {
                showMenuProduct();
            }
            else if (conti.equals("No")) {
                System.exit(0);
            }

        }
        else if (numChucNang == 4) {
            // hiển thị danh sách để chọn id
            List<Product> products = productDAO.getListProduct();
            productDAO.show(products);

            System.out.println("**** Chức năng xóa sản phẩm theo ID");
            System.out.print("Nhập id điện thoại cần xoá: ");
            int id = 0;
            sc = new Scanner(System.in);
            id = sc.nextInt();

            int numAffect = productDAO.delete(id);
            if (numAffect > 0) {
                System.out.println("Xoá điện thoại thành công, id = " + id);
            } else {
                System.out.println("Xoá không thành công, id không tồn tại");
            }
            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.equals("Yes")) {
                showMenuProduct();
            }
            else if (conti.equals("No")) {
                System.exit(0);
            }

        }
        else if (numChucNang == 2) {
            System.out.println("**** Chức năng thêm sản phẩm mới");
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

            productDAO.addProduct(nameNewProduct, priceNewProduct, brandNewProduct, stockNewProduct);
            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.equals("Yes")) {
                showMenuProduct();
            }
            else if (conti.equals("No")) {
                System.exit(0);
            }
        }

        else if(numChucNang == 3) {
            System.out.println("**** Chức năng cập nhật sản phẩm");
            List<Product> products = productDAO.getListProduct();
            productDAO.show(products);

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

            productDAO.updateProduct(id, nameNewProduct, priceNewProduct, brandNewProduct, stockNewProduct);
            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.equals("Yes")) {
                showMenuProduct();
            }
            else if (conti.equals("No")) {
                System.exit(0);
            }
        }
    }

    private static void showMenuProduct() {
        System.out.println("1. Hiển thị danh sách sản phẩm");
        System.out.println("2. Thêm sản phẩm mới");
        System.out.println("3. Cập nhật thông tin sản phẩm");
        System.out.println("4. Xoá sản phẩm theo ID");
        System.out.println("5. Tìm kiếm theo Brand");
        System.out.println("6. Tìm kiếm theo khoảng giá");
        System.out.println("7. Tìm kiếm theo tồn kho");
        System.out.println("8. Quay lại menu chính");
        System.out.println("===================================");

        chooseMenuProduct();
    }
}