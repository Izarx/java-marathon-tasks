package com.softserve.itacademy.stage3.ex1;

public class Oven {
    public static Pizza cook() {
        return Pizza.base().addCheese("Mozarella").
                addSeafood("Shrimps").
                addVegetable("Tomato").build();
    }
}
