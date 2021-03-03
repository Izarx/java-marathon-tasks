package com.softserve.itacademy.stage2.ex5;

public class Square extends Figure {

  //  private double width;

    public Square(final double width)
    {
        super(width);
    }

    @Override
    public double getPerimeter()
    {
        return getWidth()*4;
    }


}
