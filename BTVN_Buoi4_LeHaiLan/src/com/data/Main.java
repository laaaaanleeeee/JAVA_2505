package com.data;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Cơ bản 2
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhập vào số phần tử của mảng: ");
//        int n = sc.nextInt();
//        int[] mang = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            System.out.print("Nhập vào các phẩn tử của mảng: ");
//            mang[i] = sc.nextInt();
//        }
//
//        int sum = 0;
//        for (int j = 0; j < mang.length; j++) {
//            sum += mang[j];
//        }
//        System.out.println("Tổng các phần tử trong mảng là: " + sum);




        // Cơ bản 3
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhập vào số phần tử của mảng: ");
//        int n = sc.nextInt();
//        int[] mang = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            System.out.print("Nhập vào các phẩn tử của mảng: ");
//            mang[i] = sc.nextInt();
//        }
//
//        int countEven = 0;
//        for (int i = 0; i < mang.length; i++) {
//            if(mang[i] % 2 == 0) {
//                countEven += 1;
//            }
//        }
//        System.out.println("Số phẩn tử chẵn trong mảng là: " + countEven);




        // Cơ bản 4
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhập vào số phần tử của mảng: ");
//        int n = sc.nextInt();
//        if (n == 0) {
//            System.out.println("Mảng có kích thước rỗng");
//        }
//        int[] mang = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            System.out.print("Nhập vào các phẩn tử của mảng: ");
//            mang[i] = sc.nextInt();
//        }
//        System.out.println("Mảng cũ: " + Arrays.toString(mang));
//
//        for (int i = 0; i < n/2; i++) {
//            int temp = mang[i];
//            mang[i] = mang[n - i - 1];
//            mang[n - i - 1] = temp;
//        }
//
//        System.out.println("Mảng mới: " + Arrays.toString(mang));


        // Khá 5
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhập vào số phần tử của mảng: ");
//        int n = sc.nextInt();
//        if (n == 0) {
//            System.out.println("Mảng có kích thước rỗng");
//        }
//        int[] mang = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            System.out.print("Nhập vào các phẩn tử của mảng: ");
//            mang[i] = sc.nextInt();
//        }
//        System.out.println(Arrays.toString(mang));
//
//        int max = mang[0];
//        int min = mang[0];
//
//        for (int i = 0; i < mang.length; i++) {
//            if(mang[i] % 2 != 0 && mang[i] > max) {
//                max = mang[i];
//            }
//            else if(mang[i] % 2 != 0 && mang[i] < min) {
//                min = mang[i];
//            }
//        }
//
//        System.out.println("Phần tử lẻ lớn nhất mảng là: " + max);
//        System.out.println("Phần tử lẻ nhỏ nhất mảng là: " + min);



        // Khá 6
//        int[] originalArray = {10,20,30,40,50,10,20,60,70,80,90,100,10,20,30,40,50,60,70,80};
//        int[] markingArray = new int[1000];
//
//        for (int i = 0; i < originalArray.length; i++) {
//            int value = originalArray[i];
//            if (value > 1 && value < 1000) {
//                markingArray[value - 1]++;
//            }
//        }
//
//        int max = 0;
//        for (int i = 0; i < markingArray.length; i++) {
//            if(markingArray[i] > max) {
//                max = markingArray[i];
//            }
//        }
//
//        for (int i = 0; i < markingArray.length; i++) {
//            if (markingArray[i] == max) {
//                System.out.println("Phần tử xuất hiện nhiều nhất là: " + (i+1) + " với tần suất là: " + max);
//            }
//        }



        // Giỏi 7
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhập vào số phần tử của mảng: ");
//        int n = sc.nextInt();
//        if (n == 0) {
//            System.out.println("Mảng có kích thước rỗng");
//        }
//        int[] mang = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            System.out.print("Nhập vào các phẩn tử của mảng: ");
//            mang[i] = sc.nextInt();
//        }
//
//
//        int[] mangNew = new int[n];
//        int index = 0;
//        for (int i = 0; i < mang.length; i++) {
//            if(mang[i] % 2 == 0) {
//                mangNew[index++] = mang[i];
//            }
//        }
//
//        for (int i = 0; i < mang.length; i++) {
//            if(mang[i] % 2 != 0) {
//                mangNew[index++] = mang[i];
//            }
//        }
//
//        System.out.println(Arrays.toString(mangNew));
    }
}
