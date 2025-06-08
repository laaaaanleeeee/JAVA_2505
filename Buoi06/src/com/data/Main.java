package com.data;

import com.data.inheritance.MyCar;
import contructor.OrderData;
import contructor.Product;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Person ps = new Person();
//        ps.setFullName("LaanLee");
//        System.out.println(ps.getFullName());

//        OrderData od = new OrderData(1, "Ha Noi", "LaanLee");
//        System.out.println("Id: " + od.getId());
//        System.out.println("Address: " + od.getAddress());
//        System.out.println("Cus Name: " + od.getCusName());

//        Product pd1 = new Product();
//        pd1.setId(1);
//        pd1.setProName("Sữa");
//        pd1.setPrice(25.5);
//        pd1.setCountry("Mẽo");
////        System.out.println("Id: "+ pd1.getId() + ", Name: "+ pd1.getProName() + ", Price: " + pd1.getPrice() + ", Country: " + pd1.getCountry());
//        System.out.println(pd1);
//
//        Product pd2 = new Product();
//        pd2.setId(2);
//        pd2.setProName("Xúc xích");
//        pd2.setPrice(40.0);
//        pd2.setCountry("Tàu");
////        System.out.println("Id: "+ pd2.getId() + ", Name: "+ pd2.getProName() + ", Price: " + pd2.getPrice() + ", Country: " + pd2.getCountry());
//        System.out.println(pd2);
//
//        Product pd3 = new Product(3, "Trứng", 2.0, "Việt Nam");
////        System.out.println("Id: "+ pd3.getId() + ", Name: "+ pd3.getProName() + ", Price: " + pd3.getPrice() + ", Country: " + pd3.getCountry());
//        System.out.println(pd3);
//
//        Product pd4 = new Product(4, "Thịt", 400.0, "Úc");
////        System.out.println("Id: "+ pd4.getId() + ", Name: "+ pd4.getProName() + ", Price: " + pd4.getPrice() + ", Country: " + pd4.getCountry());
//        System.out.println(pd4);

//        MyCar mc = new MyCar();
//        mc.id = 1;
//        mc.name = "Xe đạp";
//        mc.country = "Việt Nam";
//        mc.ownerName = "LaanLee";
//        System.out.println(mc);


        Scanner sc = new Scanner(System.in);
        Student sd = new Student();
        System.out.print("Nhập tên sinh viên: ");
        sd.fullName = sc.nextLine();
        System.out.print("Nhập giới tính: ");
        sd.gender = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        sd.address = sc.nextLine();
        System.out.print("Nhập ngày sinh: ");
        sd.dateBirth = sc.nextLine();
        // SimpleDateFormat
        System.out.print("Nhập mã sinh viên: ");
        sd.msv = sc.nextInt();
        System.out.print("Nhập điểm trung bình: ");
        sd.dtb = sc.nextDouble();
        sc = new Scanner(System.in);
        System.out.print("Nhập email: ");
        sd.email = sc.nextLine();

        System.out.println(sd);

        if(sd.dtb > 8.0) {
            System.out.println("Sinh viên đủ điều kiện đạt học bổng!");
        }
        else {
            System.out.println("Chúc may mắn lần sau!");
        }
    }
}
