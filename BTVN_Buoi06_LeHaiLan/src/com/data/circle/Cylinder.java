package com.data.circle;

public class Cylinder extends Circle {
    public double height;

    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
