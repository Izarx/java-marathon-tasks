package com.softserve.itacademy.stage2.ex6;

public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(final String name, final double height, final double width)
    {
        super(name);
        this.height = height;
        this.width = width;
    }

    @Override
    double getArea()
    {
        return height*width;
    }

    @Override
    public boolean equals(final Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof Rectangle))
        {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.getHeight(), getHeight()) == 0 && Double.compare(rectangle.getWidth(), getWidth()) == 0 && getName().equals(rectangle.getName());
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = (int) (prime * result + Double.doubleToLongBits(height));
        result = (int) (prime * result + Double.doubleToLongBits(width));
        return result;
    }

    public double getHeight()
    {
        return height;
    }

    public double getWidth()
    {
        return width;
    }
}
