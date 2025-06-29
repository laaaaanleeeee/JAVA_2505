package com.data.electric;

public class Tv implements IElectronic {
    @Override
    public void turnOn() {
        System.out.println("Turning on Tv...");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off Tv...");
    }
}
