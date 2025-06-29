package com.data.demooverride;

public class TestOverride {
    public static void main(String[] args) {
        Boss bs = new Boss();
        Employee ep = new Employee();
        bs.tinhTien(5000000, 300000);
        ep.tinhTien(6000000, 200000);
    }
}
