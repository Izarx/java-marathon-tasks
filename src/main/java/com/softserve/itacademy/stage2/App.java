package com.softserve.itacademy.stage2;


import com.softserve.itacademy.stage2.ex4.Employee;
import com.softserve.itacademy.stage2.ex4.Manager;
import com.softserve.itacademy.stage2.ex5.Figure;
import com.softserve.itacademy.stage2.ex4.MyUtils;
import com.softserve.itacademy.stage2.ex5.Rectang;
import com.softserve.itacademy.stage2.ex5.Square;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args)
    {
        List <Employee> persons = new ArrayList<>();
        persons.add(new Employee("Ivan", 10, BigDecimal.valueOf(3000.00)));
        persons.add(new Manager("Petro", 9, BigDecimal.valueOf(3000.00), 1.5));
        persons.add(new Employee("Stepan", 8, BigDecimal.valueOf(4000.00)));
        persons.add(new Employee("Stepan", 8, BigDecimal.valueOf(4000.00)));
        persons.add(new Employee("Andriy", 7, BigDecimal.valueOf(3500.00)));
        persons.add(new Employee("Ihor", 5, BigDecimal.valueOf(4500.00)));
        persons.add(new Manager("Vasyl", 8, BigDecimal.valueOf(2000.00), 2.0));
        persons.add(new Manager("Vasyl", 8, BigDecimal.valueOf(2000.00), 2.0));

        new MyUtils().largestEmployees(persons);

        System.out.println("---------------------------------------------------");

        List<Figure> squares = new ArrayList<>();

        squares.add(new Square(4));
        squares.add(new Square(5));
        squares.add(new Rectang(2, 3));

        //System.out.println(new MyUtils().sumPerimeter(squares));



    }
}

