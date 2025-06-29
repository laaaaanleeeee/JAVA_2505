package com.data.demostatic;

public class TestStudent2 {
    public static void main(String[] args) {
        Student2 st2 = new Student2();
        st2.studentName = "Lân";
        Student2.schoolName = "THPT Phạm Hồng Thái";

        System.out.println("Tên: " + st2.studentName);
        System.out.println("Tên trường: " + st2.schoolName);

        Student2 st3 = new Student2();
        st3.studentName = "Lê";
        System.out.println("Tên: " + st3.studentName);
        System.out.println("Tên trường: " + st3.schoolName);
    }
}
