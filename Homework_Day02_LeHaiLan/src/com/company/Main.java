package com.company;


public class Main {

    public static void main(String[] args) {
        // CB1 Khai báo và sử dụng biến

//	    int a = 100;
//        double db = 9.99;
//        char ch = 'z';
//        String str = "LaanLee";
//
//        System.out.println(a);
//        System.out.println(db);
//        System.out.println(ch);
//        System.out.println(str);



        // CB2 Toán tử số học

//        int a = 4;
//        int b = 6;
//        System.out.println("a = " + a + " va b = " + b);
//
//        System.out.println("Tong cua 2 so a+b = " + (a+b));
//        System.out.println("Hieu cua 2 so a-b = " + (a-b));
//        System.out.println("Tich cua 2 so a*b = " + (a*b));
//        System.out.println("Thuong cua 2 so a/b = " + (a/b));
//        System.out.println("So du khi chia so a cho b = " + (a%b));



        // CB3 Toán tử so sánh

//        int x = 1;
//        int y = 2;
//        System.out.println(x == y);
//        System.out.println(x != y);
//        System.out.println(x > y);
//        System.out.println(x < y);
//        System.out.println(x >= y);
//        System.out.println(x <= y);



        // CB4 Toán tử logic

//        boolean a = true;
//        boolean b = false;
//        boolean c = true;
//
//        String rs1 = a && b == true ? "Ca hai gia tri a va b deu dung" : "Hoac a sai hoac b sai";
//        String rs2 = a || b == true ? "Trong a va b co it nhat 1 gia tri dung" : "Ca 2 gia tri a va b deu sai";
//        String rs3 = !c == true ? "Phu dinh cua c la dung" : "Phu dinh cua c la sai";
//
//        System.out.println(rs1);
//        System.out.println(rs2);
//        System.out.println(rs3);



        // Kha5 Tính diện tích và chu vi của hình chữ nhật

//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhap vao chieu rong: ");
//        float width = sc.nextFloat();
//        System.out.print("Nhap vao chieu cao: ");
//        float height = sc.nextFloat();
//
//        float area = width * height;
//        System.out.println("Dien tich hinh chu nhat la: " + area );
//        float circumference = (width + height)*2;
//        System.out.println("Chu vi hinh chu nhat la: " + circumference);



        // Kha6 Quản lý điểm học sinh

//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhap vao ten sinh vien: ");
//        String tenSv = sc.nextLine();
//
//        System.out.print("Nhap diem mon hoc 1: ");
//        float diem1 = sc.nextFloat();
//        System.out.print("Nhap diem mon hoc 2: ");
//        float diem2 = sc.nextFloat();
//        System.out.print("Nhap diem mon hoc 3: ");
//        float diem3 = sc.nextFloat();
//
//        float dTb = (diem1 + diem2 + diem3) / 3;
//
//        System.out.println("-------------------Hien thi thong tin sinh vien-------------------");
//        System.out.println("Ten sinh vien : " + tenSv);
//        System.out.println("Diem mon 1 : " + diem1 + " | Diem mon 2 : " + diem2 + " | Diem mon 3 : " + diem3);
//        System.out.println("Diem trung binh : " + dTb);
//        if ( dTb < 5 ) {
//            System.out.println("Danh gia : Hoc lai");
//        }
//        else {
//            System.out.println("Danh gia : Duoc len lop");
//        }



        // Gioi7 Quản lý thời gian

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thoi gian bat dau!");
        System.out.print("Nhap so gio bat dau: ");
        int hourStart = sc.nextInt();
        System.out.print("Nhap so phut bat dau: ");
        int minusStart = sc.nextInt();
        System.out.print("Nhap so giay bat dau: ");
        int secondStart = sc.nextInt();

        System.out.println("Nhap thoi gian cong them!");
        System.out.print("Nhap so gio cong them: ");
        int hourPlus = sc.nextInt();
        System.out.print("Nhap so phut cong them: ");
        int minusSPlus = sc.nextInt();
        System.out.print("Nhap so giay cong them: ");
        int secondPlus = sc.nextInt();

        System.out.println("-------------------Input-------------------");
        System.out.println("Thoi gian bat dau: " + hourStart + " gio " + minusStart + " phut " + secondStart + " giay");
        System.out.println("Thoi gian cong them: " + hourPlus + " gio " + minusSPlus + " phut " + secondPlus + " giay");


        int timeStart = hourStart * 3600 + minusStart * 60 + secondStart;
        int timePlus = hourPlus * 3600 + minusSPlus * 60 + secondPlus;
        int totalTime = timeStart + timePlus;

        int hourTotal = totalTime / 3600;
        int minusTotal = (totalTime % 3600) / 60;
        int secondTotal = totalTime % 60;

        System.out.println("-------------------Output-------------------");
        System.out.println("Tong thoi gian: " + hourTotal + " gio " + minusTotal + " phut " + secondTotal + " giay");
    }
}
