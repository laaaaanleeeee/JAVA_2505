package com.data;

import java.util.Scanner;

public class DataMang {
//    public int tong2so() {
//        int a = 12;
//        int b = 3;
//        int tong = a + b;
//        return tong;
//    }


    public boolean xetHanhKiem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào họ tên: ");
        String hoTen = sc.nextLine();

        sc = new Scanner(System.in);
        System.out.print("Nhập vào điểm trung bình: ");
        float dTb = sc.nextFloat();

        sc = new Scanner(System.in);
        System.out.print("Nhập vào hạnh kiểm: ");
        String hanhKiem = sc.nextLine();

        if (dTb >= 7 && hanhKiem.equals("khá") || hanhKiem.equals("tốt")) {
            return true;
        }
        return false;
    }
}
