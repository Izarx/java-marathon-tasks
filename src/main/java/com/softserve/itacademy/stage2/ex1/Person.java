package com.softserve.itacademy.stage2.ex1;

public class Person
{
    int age;
    String healthInfo;
    String name;

    public Person(final int age, final String healthInfo, final String name)
    {
        this.age = age;
        this.healthInfo = healthInfo;
        this.name = name;
    }

    public String getHealthStatus(){
        return name +" " + healthInfo;
    }
}
