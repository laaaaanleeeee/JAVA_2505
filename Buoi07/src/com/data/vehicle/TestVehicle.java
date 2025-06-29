package com.data.vehicle;

public class TestVehicle {
    public static void main(String[] args) {
        Car cr = new Car();
        cr.setName("BMW");
        cr.setSpeed(300);
        cr.displayInfo();
        cr.start();

        Bike bk = new Bike();
        bk.setName("Thống Nhất");
        bk.setSpeed(12);
        bk.displayInfo();
        bk.start();
    }
}
