package com.softserve.itacademy.stage5.ex2;

public class App {
    public static void main(String[] args)
    {

        Plant plant = Plant.tryCreatePlant("", "", null);
        System.out.println(plant.toString());

    }
}
