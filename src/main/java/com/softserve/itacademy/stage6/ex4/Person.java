package com.softserve.itacademy.stage6.ex4;

public class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

     DecisionMethod<String, Integer> goShopping = (v1, v2) -> v1=="product1" && v2 > 10;
}
