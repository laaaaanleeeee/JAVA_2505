package com.data.employee;

public class Developer extends Employee {
    private String programmingLanguage;

    public Developer() {
        System.out.println("Hàm khởi tạo không tham số");
    }

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + getName() + '\'' +
                ", id=" + getId() +
                ", salary=" + getSalary() +
                ", programmingLanguage='" + programmingLanguage + '\'' +
                '}';
    }
}
