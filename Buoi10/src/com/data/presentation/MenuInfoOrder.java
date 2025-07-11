package com.data.presentation;

public class MenuInfoOrder {
    public static void showMenuInfoOrder() {
        System.out.println("1. Hiển thị danh sách hoá đơn");
        System.out.println("2. Thêm mới đơn hàng");
        System.out.println("3. Tìm kiếm hoá đơn");
        System.out.println("4. Thống kê doanh thu");
        System.out.println("5. Quay lại menu chính");
        System.out.println("======================================");

        InfoOrderMenu.chooseMenuInvoice();
    }


    public static void showMenuSearchOrder() {
        System.out.println("1. Tìm kiếm theo tên khách hàng");
        System.out.println("2. Tìm kiếm theo ngày/tháng/năm");
        System.out.println("3. Quay lại menu hoá đơn");

        InfoOrderMenu.chooseMenuSearchInvoice();
    }


    public static void showMenuStatistics() {
        System.out.println("1. Doanh thu theo ngày");
        System.out.println("2. Doanh thu theo tháng");
        System.out.println("3. Doanh thu theo năm");
        System.out.println("4. Quay lại menu chính");

        InfoOrderMenu.chooseMenuStatistics();
    }
}
