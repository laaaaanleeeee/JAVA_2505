package com.data.animal;

public class TestAnimals {
    public static void main(String[] args) {
        Animals[] anm = new Animals[3];

        anm[0] = new Dog("Milu", 5, "Poodle");
        anm[1] = new Cat("Ki", 2, "Trắng");
        anm[2] = new Animals("Sin", 10);

        for (Animals a : anm) {
            System.out.println(a.displayInfo());
            System.out.println(a.makeSound());
        }
    }
}
