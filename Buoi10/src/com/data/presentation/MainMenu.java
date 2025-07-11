package com.data.presentation;

import java.awt.*;
import java.util.Scanner;

public class MainMenu {
    public static void showMenu() {
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
                MenuProduct.showMenuProduct();
                break;
            case 2:
                System.out.println("==== Chức năng Quản lý khách hàng ====");
                MenuCustomer.showMenuCustomer();
                break;
            case 3:
                System.out.println("==== Chức năng Quản lý hoá đơn ====");
                MenuInfoOrder.showMenuInfoOrder();
                break;
            case 4:
                System.out.println("==== Chức năng Quản lý doanh thu ====");
                break;
            default:
                System.out.println("=======================================================");
                System.out.print("Bạn có chắc là muốn đăng xuất (Yes/No)? ");
                sc = new Scanner(System.in);
                String conti = sc.nextLine();
                if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                    MenuOption.chooseOption();
                }
                else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                    showMenu();
                }
        }
    }
}
