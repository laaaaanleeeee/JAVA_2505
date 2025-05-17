package com.company;

import java.util.Scanner;

public class Main {
    static void myMethod() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao 3 canh cua 1 hinh tam giac");
        System.out.print("Canh 1: ");
        int canh1 = sc.nextInt();
        System.out.print("Canh 2: ");
        int canh2 = sc.nextInt();
        System.out.print("Canh 3: ");
        int canh3 = sc.nextInt();

        int chuvi = (canh1 + canh2 + canh3);
        System.out.println("Chu vi hinh tam giac la: " + chuvi);

        if((canh1 + canh2 > canh3) && (canh1 + canh3 > canh2) && (canh2 + canh3 > canh1)) {
            System.out.println("La 1 hinh tam giac");
        }
        else {
            System.out.println("Khong phai la hinh tam giac");
        }
    }

    public static void main(String[] args) {
//	    System.out.println("Success");
//
//        int moneyTCB = 15000;
//        int moneyVCB = 300000;
//        int total = moneyVCB + moneyTCB;
//        System.out.println(total);
//
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhập họ tên: ");
//        String fullName = sc.nextLine();
//        System.out.println("Tên vừa nhập là: " + fullName);
//
//        // Nhập vào 1 số và in ra màn hình giá trị gấp 10 lần nó
//        sc = new Scanner(System.in);
//        System.out.print("Nhập vào 1 số bất kỳ: ");
//        int num = sc.nextInt();
//        System.out.println("Giá trị gấp 10 lần số vừa nhập là : " + (num * 10));


//        int result1 = 10 % 4;
//        int result2 = 100 % 9;
//        int result3 = 4 % 9;
//        System.out.println(result1);
//        System.out.println(result2);
//        System.out.println(result3);


//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhap vao 1 so bat ky: ");
//        int num = sc.nextInt();
//        if (num > 100) {
//            System.out.println("Gia tri lon hon 100, OK!");
//        }
//        else {
//            System.out.println("Gia tri nho hon 100, yeu cau nhap lai!");
//        }


//        Scanner sc = new Scanner(System.in);
//        // Bai 1
//        System.out.print("Nhap vao 1 so bat ky: ");
//        int num1 = sc.nextInt();
//        if(num1 > 0) {
//            System.out.println("So duong");
//        }
//        else {
//            System.out.println("So am");
//        }
//
//        // Bai 2
//        sc = new Scanner(System.in);
//        System.out.print("Nhap vao 1 so bat ky: ");
//        int num2 = sc.nextInt();
//        if (num2 == 6 || num2 == 7) {
//            System.out.println("Du tuoi vao lop 1");
//        }
//        else if (num2 > 7){
//            System.out.println("Qua tuoi roi");
//        }
//        else {
//            System.out.println("Chua du tuoi");
//        }
//
//
//        // Bai 3
//        sc = new Scanner(System.in);
//        System.out.println("Nhap vao 3 diem toan, ly, hoa");
//        System.out.print("Nhap vao diem toan: ");
//        float toan = sc.nextFloat();
//        System.out.print("Nhap vao diem ly: ");
//        float ly = sc.nextFloat();
//        System.out.print("Nhap vao diem hoa: ");
//        float hoa = sc.nextFloat();
//
//        float dtb = (toan + ly + hoa) / 3;
//        System.out.println("Diem trung binh 3 mon la: " + dtb);
//        if(dtb >= 8) {
//            System.out.println("Hoc luc Gioi");
//        }
//        else if (dtb >= 6.5) {
//            System.out.println("Hoc luc Kha");
//        }
//        else if (dtb >= 5) {
//            System.out.println("Hoc luc Trung binh");
//        }
//        else {
//            System.out.println("Hoc luc Yeu");
//        }


//        int level = 5;
//        switch (level) {
//            case 1:
//                System.out.println("Level thấp");
//                break;
//            case 2:
//                System.out.println("Level gà");
//                break;
//            case 3:
//                System.out.println("Level ổn");
//                break;
//            case 4:
//                System.out.println("Level pro");
//                break;
//            default:
//                System.out.println("Master class");
//                break;
//        }

//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhap ten: ");
//        String ten = sc.nextLine();
//
//        System.out.print("Nhap tuoi: ");
//        int tuoi = sc.nextInt();
//
//        sc = new Scanner(System.in);
//        System.out.print("Nhap dia chi: ");
//        String dc = sc.nextLine();
//
//        if(tuoi > 30 || dc.equals("Ha Noi")) {
//            System.out.println("Du dieu kien tham gia");
//        }
//        else {
//            System.out.println("Chua du dieu kien tham gia");
//        }


        // Bai 4
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhap tuoi: ");
//        int tuoi = sc.nextInt();
//        if(tuoi > 18 || tuoi < 27) {
//            System.out.println("Du dieu kien");
//        }
//        else {
//            System.out.println("Khong du");
//        }

        // Bai 5
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhap tai khoan: ");
//        String tk = sc.nextLine();
//        System.out.print("Nhap mat khau: ");
//        String mk = sc.nextLine();
//
//        if(tk.equals("admin") && mk.equals("123456")) {
//            System.out.println("Dang nhap thanh cong");
//        }
//        else {
//            System.out.println("Sai thong tin");
//        }

        myMethod();


    }



}
