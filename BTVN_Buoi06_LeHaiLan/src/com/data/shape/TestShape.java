package com.data.shape;

public class TestShape {
    public static void main(String[] args) {
        Shape[] sp = new Shape[4];

        sp[0] = new Shape("Hình gì đó");
        sp[1] = new Circle("Hình tròn", 3);
        sp[2] = new Rectangle("Hình chữ nhật", 8, 5);
        sp[3] = new Triangle("Hình tam giác", 3,4,5);

        for (Shape s : sp) {
            System.out.println(s.toString());
        }
    }
}
