package com.data;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // các hàm cơ bản của String
        // trim(): cắt khoảng trắng trước và sau chuỗi
        // VD: "     Nguyễn Ngọc       " ==> "Nguyễn Ngọc"

        // split: cắt chuỗi theo ký tự: "space", ",", ".", ";",...
        // VD: Cắt chuỗi "Nguyễn Văn Ngọc" theo dấu cách
        // split: kết quả là mảng: "Nguyễn", "Văn", "Ngọc"

        // equals: so sánh giá trị chuỗi
        // VD: equals to: String ("Nam") == String ("Nam") ==> chắc chắn bằng
        // ==: so sánh giá trị tham chiếu
        // VD: == String ("Nam") != String ("Nam") ==> chưa chắc bằng nhau

        // indexOf: lấy vị trí chuỗi
        // indexOf: Chuỗi "xin": trong chuỗi "Tôi xin phép nghỉ 1 hôm"
        // indexOf: trả về giá trị vị trí 4

        // length: lấy độ dài chuỗi
        // VD: chuỗi "Nguyễn" ==> 6

        // replace: thay thế chuỗi
        // VD: chuỗi "ab" thanh "xx" trong chuỗi "Phanh abs của absan bi hong"


//        String fullName = "     Tôn Ngộ Không   ";
//        System.out.println(fullName.trim());

//        String fullName2 = "Hello World";
//        String[] rs = fullName2.split(" ");
//        System.out.println(rs[1]);


//        String time = "Thời gian nghỉ hè là 1/6";
//        String chuoi1 = "gia";
//        String chuoi2 = "Gia";
//        String chuoi3 = "i";
//
//        System.out.println(time.indexOf(chuoi1));
//        System.out.println(time.indexOf(chuoi2));
//        System.out.println(time.indexOf(chuoi3));


//        // So sánh ==
//        String name1 = "a";
//        String name2 = new String("a");
//        String name3 = "a";
//
//        System.out.println(name1 == name3);
//        // name1 và name3 đều được lưu ở String pool nên sẽ trả về true
//        System.out.println(name1 == name2);
//        // Do name2 được lưu ở Stack mà stack chứa địa chỉ ô nhớ các giá trị còn name1 là được lưu ở String pool nên sẽ trả về false
//
//        // So sánh equals
//        System.out.println(name1.equals(name3));
//        System.out.println(name2.equals(name3));
//        // Khi dùng equals thì cả 2 trường hợp sẽ trả về true


//        int[] arrNumber = new int[7];
//
//        System.out.println(arrNumber[0]);
//        System.out.println(arrNumber[3]);
//
//        arrNumber[0] = 5;
//        arrNumber[1] = 8;
//        arrNumber[2] = 2;
//        arrNumber[3] = 3;
//        arrNumber[4] = 100;
//        arrNumber[5] = 2000;
//        arrNumber[6] = 5000000;
//
//        System.out.println(arrNumber[0]);
//        System.out.println(arrNumber[3]);
//
//        for (int i = 0; i < arrNumber.length; i++) {
//            System.out.println("Phần tử "+ (i+1) + ": " + arrNumber[i]);
//        }


//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhập vào số lượng phần tử trong mảng: ");
//        int n = sc.nextInt();
//        int[] mangSo = new int[n];
//
//        for (int i = 0; i < mangSo.length; i++) {
//            System.out.print("Nhập vào phần tử thứ " + (i+1) +" : " );
//            mangSo[i] = sc.nextInt();
//        }
//        System.out.println(Arrays.toString(mangSo));
//
//        int sum = 0;
//        for (int i = 0; i < mangSo.length; i++) {
//            sum += mangSo[i];
//        }
//        System.out.println("Tổng các phần tử trong mảng là: " + sum);
//
//        int sum2 = 0;
//        for (int i = mangSo.length - 1; i > (mangSo.length)-5 ; i--) {
//            sum2 += mangSo[i];
//        }
//        System.out.println("Tổng 4 phần tử cuối trong mảng là: " + sum2);
//
//        int sum3 = 0;
//        for (int i = 0; i < mangSo.length; i++) {
//            if(mangSo[i] % 2 != 0 && mangSo[i] > 0) {
//                sum3 += mangSo[i];
//            }
//        }
//        System.out.println("Tổng các phần tử lẻ và không âm là: " + sum3);


        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số lượng phần tử trong mảng: ");
        String inputN = sc.nextLine();
        int n = 0;
        try {
            // Interger.parseInt => chuyển đổi sang kiểu dữ liệu number
            n = Integer.parseInt(inputN);
            System.out.println("N: " + n);
        }
        catch (Exception ex) {
            System.out.println("Giá trị không phải số, vui lòng nhập lại");
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập vào phần tử thứ " + (i+1) + " : ");
            arr[i] = sc.nextInt();
        }

        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
