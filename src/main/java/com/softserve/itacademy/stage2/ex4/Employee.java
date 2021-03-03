package com.softserve.itacademy.stage2.ex4;

import java.math.BigDecimal;

public class Employee {

    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee() {}

    public Employee(final String name, final int experience, final BigDecimal basePayment)
    {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName()
    {
        return name;
    }

    public int getExperience()
    {
        return experience;
    }

    public BigDecimal getBasePayment()
    {
        return basePayment;
    }

    public BigDecimal getPayment()
    {
        return basePayment;
    }

    @Override
    public boolean equals(final Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof Employee))
        {
            return false;
        }
        Employee employee = (Employee) o;
        return experience == employee.experience && name.equals(employee.name) && basePayment.equals(employee.basePayment);
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + experience;
        result = prime * result + ((basePayment == null) ? 0 : basePayment.hashCode());
        return result;
    }

    @Override
    public String toString()
    {
        return "Employee{" + "name='" + name + '\'' + ", experience=" + experience + ", basePayment=" + basePayment + '}';
    }
}
