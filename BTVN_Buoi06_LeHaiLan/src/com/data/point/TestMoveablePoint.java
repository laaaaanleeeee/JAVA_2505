package com.data.point;

public class TestMoveablePoint {
    public static void main(String[] args) {
        Point pt = new Point();
        MoveablePoint mp = new MoveablePoint();
        mp.setX(5);
        mp.setY(6);
        mp.setxSpeed(10);
        mp.setySpeed(8);
        System.out.println(mp);
        mp.move();
        System.out.println("Tọa độ mới sau khi di chuyển: x = " + mp.x + ", y = " + mp.y);

    }
}
