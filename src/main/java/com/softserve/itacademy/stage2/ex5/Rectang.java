package com.softserve.itacademy.stage2.ex5;

public class Rectang extends Figure {

    private double height;

    public Rectang(final double width, final double height)
    {
        super(width);
        this.height = height;
    }

    public double getHeight()
    {
        return height;
    }

    @Override
    public double getPerimeter()
    {
        return 2*getWidth() + 2*height;
    }
}
