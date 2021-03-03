package com.softserve.itacademy.stage1;

public class Product {

    private String name;
    private double price;
    private static int count;

    public Product() {
        count++;
    }

    public Product(final String name, final double price)
    {
        this.name = name;
        this.price = price;
        count++;
    }

    public static int count() {
        return count;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        if (name != null) {
            this.name = name;
        }
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(final double price)
    {
        this.price = price;
    }
}
