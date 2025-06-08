package com.data.animal;

public class Dog extends Animals {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + ", Giống chó: " + breed;
    }

    @Override
    public String makeSound() {
        return "Woof Woof";
    }
}
