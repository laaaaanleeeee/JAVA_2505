package com.data.demointerface;

public class TestStudent {
    public static void main(String[] args) {
        Student st1 = new Student();
        st1.showStudent();

        IStudent st2 = new Student();
        st2.showStudent();
    }
}
