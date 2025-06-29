package com.data;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        List<Integer> listNum = new ArrayList<>();
//        System.out.println("Số phần tử trong mảng là: " + listNum.size());
//
//        listNum.add(15);
//        listNum.add(8);
//        System.out.println("Số phần tử trong mảng là: " + listNum.size());
//
//        System.out.println("Phần tử đầu tiên: "+ listNum.get(0));
//        // nếu cố tình lấy ra index quá thì sẽ báo lỗi indexoutofbound
//
//        System.out.println(listNum);
//
//        // fori là vòng lặp quan tâm đến chỉ số index
//        for (int i = 0; i < listNum.size(); i++) {
//            System.out.println("Giá trị: " + listNum.get(i));
//        }
//
//        // forEach là vòng lặp không quan tâm đến thứ tự index
//        listNum.forEach(integer -> {
//            System.out.println("Giá trị: " + integer);
//        });
//
//        listNum.remove(0);



//        List<String> listStudent = new ArrayList<>();
//        listStudent.add("Lân");
//        listStudent.add("Hoài");
//        listStudent.add("Hoàng");
//        listStudent.add("Kiên");
//        listStudent.add("Hùng");
//
//        System.out.println("======== Bài 1 ========");
//        System.out.println("======== for ========");
//        for (int i = 0; i < listStudent.size(); i++) {
//            System.out.println("Sinh viên thứ " + (i +1) + " là: " + listStudent.get(i));
//        }
//
//        System.out.println("======== forEach ========");
//        listStudent.forEach(stu -> {
//            System.out.println("Sinh viên: " + stu);
//        });
//
//        System.out.println("======== Iterator ========");
//        Iterator<String> iterator = listStudent.iterator();
//
//        while (iterator.hasNext()) {
//            String stu = iterator.next();
//            System.out.println("Sinh viên: " + stu);
//        }
//
//
//        List<Integer> listNum = new ArrayList<>();
//        listNum.add(1);
//        listNum.add(2);
//        listNum.add(3);
//        listNum.add(4);
//        listNum.add(5);
//        listNum.add(6);
//        listNum.add(7);
//        listNum.add(8);
//        listNum.add(9);
//        listNum.add(10);
//
//        System.out.println("======== Bài 2 ========");
//        System.out.println("Danh sách các phần tử trước khi xóa: " + listNum);
//        for (int i = 0; i < listNum.size(); i++) {
//            if(listNum.get(i) % 3 == 0) {
//                listNum.remove(i);
//            }
//        }
//        System.out.println("Danh sách các phần tử sau khi xóa: " + listNum);
//
//
//        List<Integer> listNum2 = new ArrayList<>();
//        listNum2.add(18);
//        listNum2.add(12);
//        listNum2.add(33);
//        listNum2.add(41);
//        listNum2.add(15);
//        listNum2.add(68);
//        listNum2.add(27);
//        listNum2.add(88);
//        listNum2.add(19);
//        listNum2.add(100);
//
//        int max = listNum2.get(0);
//        int min = listNum2.get(0);
//        for (int i = 0; i < listNum2.size(); i++) {
//            if(listNum2.get(i) > max) {
//                max = listNum2.get(i);
//            }
//            else if (listNum2.get(i) < min) {
//                min = listNum2.get(i);
//            }
//        }
//
//        System.out.println("======== Bài 3 ========");
//        System.out.println(listNum2);
//        System.out.println("Phần tử lớn nhất trong danh sách là: " + max);
//        System.out.println("Phần tử nhỏ nhất trong danh sách là: " + min);
//
//
//
//        List<Integer> listNum3 = new ArrayList<>();
//        listNum3.add(1);
//        listNum3.add(2);
//        listNum3.add(3);
//        listNum3.add(4);
//        listNum3.add(5);
//        listNum3.add(6);
//        int sum = 0;
//        int countEven = 0;
//        for (int i = 0; i < listNum3.size(); i++) {
//            if(listNum3.get(i) % 2 == 0) {
//                sum += listNum3.get(i);
//                countEven += 1;
//            }
//        }
//
//        System.out.println("======== Bài phần tử chẵn ========");
//        System.out.println(listNum3);
//        System.out.println("Tổng các số chẵn trong mảng là: " + sum);
//        System.out.println("Số phần tử chẵn trong mảng là: " + countEven);


//        Set<Integer> listNum = new HashSet<>();
//        listNum.add(15);
//        listNum.add(8);
//        listNum.add(100);
//
//        System.out.println("Set number sau khi add lần 1: " + listNum);
//
//        listNum.add(8);
//        System.out.println("Set number sau khi add lần 2: "+ listNum);

//        Set<Integer> listNum = new HashSet<>();
//        listNum.add(10);
//        listNum.add(20);
//        listNum.add(30);
//        listNum.add(40);
//        listNum.add(50);
//
//        listNum.forEach(list -> {
//            System.out.println(list);
//        });
//
//
//
//        Set<String> listStr = new HashSet<>();
//        listStr.add("Java");
//        listStr.add("Python");
//        listStr.add("C++");
//        listStr.add("JavaScript");
//
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhập vào 1 chuỗi mới: ");
//        String newStr = sc.nextLine();
//
//        if(listStr.equals(newStr)) {
//            System.out.println("Đã có chuỗi này rồi");
//        }
//        else {
//            System.out.println("Chưa có chuỗi này");
//        }
//
//
//        Set<Integer> listNumbers = new HashSet<>();
//        listNumbers.add(1);
//        listNumbers.add(2);
//        listNumbers.add(3);
//        listNumbers.add(4);
//        listNumbers.add(5);
//        listNumbers.add(6);
//        listNumbers.add(7);
//        listNumbers.add(8);
//        listNumbers.add(9);
//        listNumbers.add(10);
//
//        listNumbers.removeIf(num -> num % 2 == 0);
//
//        System.out.println(listNumbers);



        List<Integer> listNum = new ArrayList<>();
        listNum.add(5);
        listNum.add(15);
        listNum.add(20);
        listNum.add(4);
        listNum.add(8);

        List<Integer> rs = listNum.stream().filter(num -> num % 2 == 1 && num > 10).toList();
        System.out.println("List các số lẻ: " + rs);


    }
}
