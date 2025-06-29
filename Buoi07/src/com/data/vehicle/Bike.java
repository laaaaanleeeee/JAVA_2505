package com.data.vehicle;

public class Bike extends Vehicle {
    @Override
    public void displayInfo() {
        System.out.println("Tên xe đạp: " + getName() + ", Tốc độ xe: " + getSpeed() + " km/h");
    }
}
