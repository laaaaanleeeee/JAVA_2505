package com.data.presentation;

import com.data.business.service.AccountService;

import java.util.Scanner;

public class MenuLogin {
    public static void showMenuLogin() {
        AccountService accountService = new AccountService();

        System.out.println("==== ĐĂNG NHẬP QUẢN TRỊ ====");
        System.out.print("Tài khoản: ");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        System.out.print("Mật khẩu: ");
        String pass = sc.nextLine();

        boolean result = accountService.checkAccount(userName, pass);

        if (result) {
            System.out.println("Đăng nhập thành công!");
            MainMenu.showMenu();
        } else {
            System.out.println("Sai tài khoản hoặc mật khẩu!");
            showMenuLogin();
        }
    }
}
