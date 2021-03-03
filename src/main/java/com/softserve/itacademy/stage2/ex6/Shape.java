package com.softserve.itacademy.stage2.ex6;

public abstract class Shape {

    private String name;

    public Shape(final String name)
    {
        this.name = name;
    }

    abstract double getArea();

    public String getName()
    {
        return name;
    }
}
