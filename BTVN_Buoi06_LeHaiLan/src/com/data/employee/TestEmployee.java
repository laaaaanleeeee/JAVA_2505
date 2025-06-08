package com.data.employee;

public class TestEmployee {
    public static void main(String[] args) {
        Employee[] ep = new Employee[3];
        ep[0] = new Employee("Lân", 1, 25.5);
        ep[1] = new Manager("Lê", 2, 50, 50);
        ep[2] = new Developer("LaanLee", 3, 20, "Java");
        ep[2].increaseSalary(50);

        for (Employee e : ep) {
            System.out.println(e.toString());
        }
    }
}
