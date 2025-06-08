package com.data.animal;

public class Animals {
    private String name;
    private int age;

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String displayInfo() {
        return "Tên động vật: " + name + ", Tuổi động vật: " + age;
    }

    public String makeSound() {
        return "Some generic sound";
    }
}
