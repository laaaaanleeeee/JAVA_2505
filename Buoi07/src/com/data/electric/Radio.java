package com.data.electric;

public class Radio implements IElectronic {
    @Override
    public void turnOn() {
        System.out.println("Turning on Radio...");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off Radio...");
    }
}
