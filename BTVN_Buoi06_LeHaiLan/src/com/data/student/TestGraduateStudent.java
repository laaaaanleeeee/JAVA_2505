package com.data.student;

public class TestGraduateStudent {
    public static void main(String[] args) {
        Student[] sd = new Student[2];

        sd[0] = new Student("Lân", "1", 3.99);
        sd[1] = new GraduateStudent("LaanLee", "2", 3.98, "Robot fighter", "Thầy Tuyên");

        for (Student s : sd) {
            System.out.println(s.getDetails());
        }
    }
}
