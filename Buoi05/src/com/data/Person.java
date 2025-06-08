package com.data;

import java.util.Scanner;

public class Person {
    public String fullname;
    public String address;
    public String phone;
    public int money;

    public void showEmail() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào email: ");
        String email = sc.nextLine();
        System.out.println("Email: " + email);
    }

    public void tinhTong() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Số phần tử trong mảng là: ");
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("Không thể nhập độ lớn mảng < 0");
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            sc = new Scanner(System.in);
            System.out.print("Nhập vào phần tử thứ " + (i+1) + " là: ");
            int pTu = sc.nextInt();
            arr[i] = pTu;
        }
        int sumArr = 0;
        for (int i = 0; i < arr.length; i++) {
            sumArr += arr[i];
        }
        System.out.println("Tổng các phần tử trong mảng là: " + sumArr);
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullname='" + fullname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", money=" + money +
                '}';
    }
}
