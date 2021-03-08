package com.softserve.itacademy.stage4.ex6;

public class Employee extends Person {

    private double salary;

    public Employee(final String name, final int age, final double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", Salary: " + salary;
    }
}
