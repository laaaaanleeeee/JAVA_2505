package com.data.presentation;

import java.util.Scanner;

public class MenuOption {
    public static void chooseOption() {
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
                MenuLogin.showMenuLogin();
            default:
                System.exit(0);
        }
    }
}
