package com.softserve.itacademy.stage2.ex6;

import java.util.Objects;

public class Circle extends Shape {

    public static double PI = 3.14;
    private double radius;

    public Circle(final String name, final double radius)
    {
        super(name);
        this.radius = radius;
    }

    @Override
    double getArea()
    {
        return PI * radius * radius;
    }

    @Override
    public boolean equals(final Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof Circle))
        {
            return false;
        }
        Circle circle = (Circle) o;
        return Double.compare(circle.getRadius(), getRadius()) == 0 && getName().equals(circle.getName());
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = (int) (prime * result + Double.doubleToLongBits(radius));
        return result;
    }

    public double getRadius()
    {
        return radius;
    }
}
