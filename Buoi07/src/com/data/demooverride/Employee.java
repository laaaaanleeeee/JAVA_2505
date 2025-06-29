package com.data.demooverride;

public class Employee extends Boss {
    public void tinhTien(int luongCung, int thuong) {
        int soTien = luongCung + thuong * 2;
        System.out.println("Số tiền: " + soTien);
    }
}
