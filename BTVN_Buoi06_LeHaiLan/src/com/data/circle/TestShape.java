package com.data.circle;

public class TestShape {
    public static void main(String[] args) {
        Circle cr = new Circle();
        Cylinder cl = new Cylinder();
        cr.setRadius(5);
        cl.setRadius(7);
        cl.setHeight(3);
        System.out.println("Diện tích hình tròn: " + cr.getArea());
        System.out.println("Thể tích hình trụ: " + cl.getVolume());
    }
}
