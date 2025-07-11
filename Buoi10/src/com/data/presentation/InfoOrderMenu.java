package com.data.presentation;

import com.data.business.model.Customer;
import com.data.business.model.Invoice;
import com.data.business.model.Product;
import com.data.business.service.CustomerService;
import com.data.business.service.InvoiceService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InfoOrderMenu {
    public static void chooseMenuInvoice() {
        InvoiceService invoiceService = new InvoiceService();
        CustomerService customerService = new CustomerService();


        System.out.print("Nhập lựa chọn: ");
        Scanner sc = new Scanner(System.in);
        int numChucNang = sc.nextInt();

        while (numChucNang < 1 || numChucNang > 5) {
            System.out.println("Số chức năng chưa đúng!. Vui lòng nhập lại:");
            numChucNang = sc.nextInt();
        }

        if (numChucNang == 5) {
            MainMenu.showMenu();
        }
        else if (numChucNang == 1) {
            System.out.println("**** Chức năng xem danh sách hoá đơn");
            List<Invoice> invoices = invoiceService.getListInvoice();
            invoiceService.show(invoices);
            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuInfoOrder.showMenuInfoOrder();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }
        }

        else if (numChucNang == 2) {
            System.out.println("**** Chức năng thêm mới hoá đơn");
            List<Customer> customers = customerService.getListCustomer();
            customerService.show(customers);
            System.out.print("Nhập mã khách hàng: ");
            sc = new Scanner(System.in);
            int cusId = sc.nextInt();

            sc = new Scanner(System.in);
            System.out.print("Nhập ngày tạo hoá đơn: ");
            String dateIn = sc.nextLine();
            java.sql.Date invoiceDate = java.sql.Date.valueOf(dateIn);

            System.out.print("Nhập tổng tiền: ");
            double newTotalAmount = sc.nextDouble();

            Invoice invoice = new Invoice(0,  cusId, invoiceDate, newTotalAmount);
            invoiceService.saveNewInvoice(invoice);

            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuInfoOrder.showMenuInfoOrder();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }
        }

        else if (numChucNang == 3) {
            MenuInfoOrder.showMenuSearchOrder();
        }
        else if(numChucNang == 4) {
            MenuInfoOrder.showMenuStatistics();
        }

    }



    public static void chooseMenuSearchInvoice() {
        InvoiceService invoiceService = new InvoiceService();


        System.out.print("Nhập lựa chọn: ");
        Scanner sc = new Scanner(System.in);
        int numChucNang = sc.nextInt();

        while (numChucNang < 1 || numChucNang > 3) {
            System.out.println("Số chức năng chưa đúng!. Vui lòng nhập lại:");
            numChucNang = sc.nextInt();
        }

        if (numChucNang == 3) {
            MenuInfoOrder.showMenuInfoOrder();
        }
        else if (numChucNang == 1) {
            System.out.println("**** Chức năng tìm kiếm hoá đơn theo tên khách hàng");
            sc = new Scanner(System.in);
            System.out.print("Nhập vào tên khách hàng để tìm kiếm hoá đơn: ");
            String cusNameIn = sc.nextLine();

            List<Invoice> invoices = invoiceService.searchListInvoiceByCusName(cusNameIn);
            invoiceService.show(invoices);

            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuInfoOrder.showMenuSearchOrder();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }
        }

        else if (numChucNang == 2) {
            System.out.println("**** Chức năng tìm kiếm hoá đơn theo ngày tạo hoá đơn");
            sc = new Scanner(System.in);
            System.out.print("Nhập vào ngày-tháng-năm để tìm kiếm hoá đơn: ");
            String dateIn = sc.nextLine();

            List<Invoice> invoices = invoiceService.searchOrderByDate(dateIn);
            invoiceService.show(invoices);

            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuInfoOrder.showMenuSearchOrder();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }
        }
    }



    public static void chooseMenuStatistics() {
        InvoiceService invoiceService = new InvoiceService();


        System.out.print("Nhập lựa chọn: ");
        Scanner sc = new Scanner(System.in);
        int numChucNang = sc.nextInt();

        while (numChucNang < 1 || numChucNang > 4) {
            System.out.println("Số chức năng chưa đúng!. Vui lòng nhập lại:");
            numChucNang = sc.nextInt();
        }

        if (numChucNang == 4) {
            MenuInfoOrder.showMenuInfoOrder();
        }
        else if (numChucNang == 1) {
            System.out.println("**** Chức năng thống kê doanh thu theo ngày");
            sc = new Scanner(System.in);
            System.out.print("Nhập năm cần thống kê: ");
            int year = sc.nextInt();
            System.out.print("Nhập tháng cần thống kê: ");
            int month = sc.nextInt();
            invoiceService.getStatisticsByDay(year, month);

            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuInfoOrder.showMenuStatistics();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }
        }

        else if (numChucNang == 2) {
            System.out.println("**** Chức năng thống kê doanh thu theo tháng");
            sc = new Scanner(System.in);
            System.out.print("Nhập năm cần thống kê: ");
            int year = sc.nextInt();
            invoiceService.getStatisticsByMonth(year);

            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuInfoOrder.showMenuStatistics();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }
        }


        else if (numChucNang == 3) {
            System.out.println("**** Chức năng thống kê doanh thu theo năm");
            invoiceService.statisticsByYear();

            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuInfoOrder.showMenuStatistics();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }
        }
    }
}
