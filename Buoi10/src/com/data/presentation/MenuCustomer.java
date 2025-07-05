package com.data.presentation;

public class MenuCustomer {

    public static void showMenuCustomer() {
        System.out.println("1. Hiển thị danh sách khách hàng");
        System.out.println("2. Thêm khách hàng mới");
        System.out.println("3. Cập nhật thông tin khách hàng");
        System.out.println("4. Xoá khách hàng theo ID");
        System.out.println("5. Quay lại menu chính");
        System.out.println("======================================");

        CustomerMenu.chooseMenuCustomer();
    }
}
