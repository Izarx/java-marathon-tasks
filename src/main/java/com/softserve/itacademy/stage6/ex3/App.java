package com.softserve.itacademy.stage6.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class App {
    static BinaryOperator<String> greetingOperator = (v1, v2) -> "Hello " + v1 + " " + v2 + "!!!";

    static List<String> createGreetings (List<Person> people, BinaryOperator<String> binaryOperator) {
        List<String> list = new ArrayList<>();
        for(Person p : people) {
            list.add(binaryOperator.apply(p.name, p.surname));
        }
        return list;
    }
}
