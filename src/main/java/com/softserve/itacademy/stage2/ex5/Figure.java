package com.softserve.itacademy.stage2.ex5;

public abstract class Figure {

    private double width;

    public Figure(final double width)
    {
        this.width = width;
    }

    public abstract double getPerimeter();

    public double getWidth()
    {
        return width;
    }
}
