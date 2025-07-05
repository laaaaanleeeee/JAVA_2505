package com.data.presentation;

public class MenuProduct {

    public static void showMenuProduct() {
        System.out.println("1. Hiển thị danh sách sản phẩm");
        System.out.println("2. Thêm sản phẩm mới");
        System.out.println("3. Cập nhật thông tin sản phẩm");
        System.out.println("4. Xoá sản phẩm theo ID");
        System.out.println("5. Tìm kiếm theo Brand");
        System.out.println("6. Tìm kiếm theo khoảng giá");
        System.out.println("7. Tìm kiếm theo tồn kho");
        System.out.println("8. Quay lại menu chính");
        System.out.println("===================================");

        ProductMenu.chooseMenuProduct();
    }
}
