package com.softserve.itacademy.stage4.ex6;

import java.util.Arrays;

public class App {
    public static void main(String[] args)
    {
        Person[] people = {new Person("Ivan", 25),
                           new Person("Ihor", 35),
                           new Person("Ostap", 28),
                           new Person("Kirill", 7),
                           new Person("Roman", 11),
                           new Person("Ihor", 5),
                           new Person("Ann", 21)};

        Utility.sortPeople(people, new PersonComparator());

        Arrays.stream(people).forEach(System.out::println);

        Employee[] employees = {new Employee("Ivan", 25, 3000.0),
                           new Employee("Ihor", 35, 2500.0),
                           new Employee("Ostap", 28, 2600.0),
                           new Employee("Kirill", 7, 3200.0),
                           new Employee("Roman", 11, 3100.0),
                           new Employee("Ihor", 35, 3500.0),
                           new Employee("Ann", 21, 3600.0)};

        Utility.sortPeople(employees, new EmployeeComparator());
        Arrays.stream(employees).forEach(System.out::println);

        Developer[] developers = {new Developer("Ivan", 25, 3000.0, Level.MIDDLE),
                                new Developer("Ihor", 35, 2500.0, Level.JUNIOR),
                                new Developer("Ostap", 28, 2600.0, Level.JUNIOR),
                                new Developer("Kirill", 7, 3200.0, Level.SENIOR),
                                new Developer("Roman", 11, 3100.0, Level.MIDDLE),
                                new Developer("Ihor", 35, 3500.0, Level.SENIOR),
                                new Developer("Ann", 21, 3600.0, Level.SENIOR)};

        Utility.sortPeople(developers, new DeveloperComparator());
        Arrays.stream(developers).forEach(System.out::println);

    }
}
