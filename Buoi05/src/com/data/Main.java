package com.data;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//	    Person person = new Person();
//        person.fullname = "LaanLee";
//        person.address = "Hà Nội";
//        person.phone = "0368063473";
//        person.money = 1100;
//
//        System.out.println(person.fullname);
//        System.out.println(person.address);
//        System.out.println(person.phone);
//        System.out.println(person.money);
//
//        System.out.println(person);
//
//        Person p2 = new Person();
//        p2.fullname = "Hai";
//        p2.address = "HP";
//        p2.phone = "0123456789";
//        p2.money = 1400;
//
//        System.out.println(p2);
//
//        Person p3 = new Person();
//        p3.showEmail();

//        Person p4 = new Person();
//        p4.tinhTong();

//        DataMang dt = new DataMang();
//        int result = dt.tong2so();
//        System.out.println("Giá trị trả về: " + result);

//        boolean rs = dt.xetHanhKiem();
//        System.out.println("Kết quả xét hạnh kiểm + điểm trung bình là: " + rs);
//
//        if(rs) {
//            System.out.println("Đủ điều kiện lên lớp");
//        }
//        else {
//            System.out.println("Bị đúp");
//        }

//        HinhTamGiac htg = new HinhTamGiac();
//        double chuVi = htg.tinhChuVi(3.5,5,6.5);
//        System.out.println("Chu vi hình tam giác: " + chuVi);

        HinhChuNhat hcn = new HinhChuNhat();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào chiều dài: ");
        int chieuDai = sc.nextInt();
        System.out.print("Nhập vào chiều rộng: ");
        int chieuRong = sc.nextInt();

        if(chieuDai < chieuRong) {
            System.out.println("Chiều dài phải lớn hơn chiều rộng");
        }
        else {
            int rsChuVi = hcn.tinhChuVi(chieuDai, chieuRong);
            int rsDienTich = hcn.tinhDienTich(chieuDai, chieuRong);
            System.out.println("Chu vi hình chữ nhật là: " + rsChuVi);
            System.out.println("Diện tích hình chữ nhật là: " + rsDienTich);
        }
    }
}
