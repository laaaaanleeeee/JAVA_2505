package com.data;

public class Student extends Person {
    public int msv;
    public double dtb;
    public String email;

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", dateBirth='" + dateBirth + '\'' +
                ", mssv=" + msv +
                ", dtb=" + dtb +
                ", email='" + email + '\'' +
                '}';
    }
}
