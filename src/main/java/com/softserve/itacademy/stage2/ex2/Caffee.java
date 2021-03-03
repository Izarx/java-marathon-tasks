package com.softserve.itacademy.stage2.ex2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Caffee implements DrinkReceipt, DrinkPreparation, Rating{

    private String name;
    private int rating;
    private Map<String, Integer> ingredients = new HashMap<>();

    public Caffee(String name, int rating)
    {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public Map<String, Integer> makeDrink()
    {
        addComponent("Water", 100);
        addComponent("Arabica", 20);
        return ingredients;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount)
    {
        this.ingredients.put(componentName, componentCount);
        return this;
    }

    @Override
    public int getRating()
    {
        return this.rating;
    }

    public Map<String, Integer> getIngredients()
    {
        return ingredients;
    }
}
