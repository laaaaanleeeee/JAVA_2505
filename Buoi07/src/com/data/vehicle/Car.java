package com.data.vehicle;

public class Car extends Vehicle {
    @Override
    public void displayInfo() {
        System.out.println("Tên xe hơi: " + getName() + ", Tốc độ xe: " + getSpeed() + " km/h");
    }
}
