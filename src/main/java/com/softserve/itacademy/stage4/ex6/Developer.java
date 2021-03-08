package com.softserve.itacademy.stage4.ex6;

public class Developer extends Employee {
    private Level level;

    public Developer(final String name, final int age, final double salary, final Level level) {
        super(name, age, salary);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", Level: " + level.name();
    }
}
