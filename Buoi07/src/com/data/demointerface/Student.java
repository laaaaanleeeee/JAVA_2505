package com.data.demointerface;

public class Student implements IStudent {
    @Override
    public void showStudent() {
        System.out.println("Name: Lân");
        System.out.println("Tuổi: 20");
    }
}
