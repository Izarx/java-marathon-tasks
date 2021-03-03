package com.softserve.itacademy.stage2.ex1;

public class Adult extends Person
{
    String passportNumber;

    public Adult(final int age, final String healthInfo, final String name, final String passportNumber) {
        super(age, healthInfo, name);
        this.passportNumber = passportNumber;
    }
}
