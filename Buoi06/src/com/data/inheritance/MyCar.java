package com.data.inheritance;

public class MyCar extends Vehicle {
    public String ownerName;

    @Override
    public String toString() {
        return "MyCar{" +
                "ownerName='" + ownerName + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
