package com.data.presentation;

import com.data.business.model.Customer;
import com.data.business.model.Product;
import com.data.business.service.CustomerService;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    public static void chooseMenuCustomer() {
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
            System.out.println("**** Chức năng xem danh sách khách hàng");
            List<Customer> customers = customerService.getListCustomer();
            customerService.show(customers);
            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuCustomer.showMenuCustomer();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }

        }
        else if (numChucNang == 4) {
            // hiển thị danh sách để chọn id
            List<Customer> customers = customerService.getListCustomer();
            customerService.show(customers);

            System.out.println("**** Chức năng xóa khách hàng theo ID");
            System.out.print("Nhập id khách hàng cần xoá: ");
            sc = new Scanner(System.in);
            int id = sc.nextInt();

            customerService.deleteCus(id);

            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuCustomer.showMenuCustomer();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }

        }
        else if (numChucNang == 2) {
            System.out.println("**** Chức năng thêm mới khách hàng");
            System.out.print("Nhập tên khách hàng:");
            sc = new Scanner(System.in);
            String newName = sc.nextLine();

            System.out.print("Nhập số điện thoại:");
            String newPhone = sc.nextLine();

            System.out.print("Nhập email:");
            String newEmail = sc.nextLine();

            System.out.print("Nhập địa chỉ:");
            String newAddress = sc.nextLine();

            Customer customer = new Customer(0,  newName, newPhone, newEmail, newAddress);
            customerService.saveCus(customer);

            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuCustomer.showMenuCustomer();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }
        }

        else if(numChucNang == 3) {
            System.out.println("**** Chức năng cập nhật khách hàng");
            List<Customer> customers = customerService.getListCustomer();
            customerService.show(customers);

            System.out.println("**** Chức năng cập nhật sản phẩm theo ID");
            System.out.print("Nhập id sản phẩm cần cập nhật: ");
            sc = new Scanner(System.in);
            int id = sc.nextInt();
            System.out.print("Nhập tên khách hàng mới: ");
            sc = new Scanner(System.in);
            String newName = sc.nextLine();
            System.out.print("Nhập số điện thoại mới: ");
            String newPhone = sc.nextLine();
            System.out.print("Nhập email mới: ");
            String newEmail = sc.nextLine();
            System.out.print("Nhập địa chỉ mới: ");
            String newAddress = sc.nextLine();

            Customer customer = new Customer(id,  newName, newPhone, newEmail, newAddress);
            customerService.updateCus(customer);
            System.out.println("=======================================================");
            System.out.print("Bạn có muốn tiếp tục các chức năng (Yes/No)? ");
            sc = new Scanner(System.in);
            String conti = sc.nextLine();
            if(conti.toLowerCase().equals(("Yes").toLowerCase())) {
                MenuCustomer.showMenuCustomer();
            }
            else if (conti.toLowerCase().equals(("No").toLowerCase())) {
                System.exit(0);
            }
        }
    }
}
