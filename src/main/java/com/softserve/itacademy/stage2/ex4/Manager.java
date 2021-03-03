package com.softserve.itacademy.stage2.ex4;

import java.math.BigDecimal;

public class Manager extends Employee {

    private double coefficient;

    public Manager() {}

    public Manager(final String name, final int experience, final BigDecimal basePayment, final double coefficient)
    {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    public double getCoefficient()
    {
        return coefficient;
    }

    @Override
    public BigDecimal getPayment()
    {
        return super.getPayment().multiply(BigDecimal.valueOf(coefficient));
    }

    @Override
    public boolean equals(final Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof Manager))
        {
            return false;
        }
        if(!super.equals(o))
        {
            return false;
        }
        Manager manager = (Manager) o;
        return Double.compare(manager.getCoefficient(), getCoefficient()) == 0;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + getExperience();
        result = prime * result + ((getBasePayment() == null) ? 0 : getBasePayment().hashCode());
        result = (int) (prime * result + Double.doubleToLongBits(coefficient));
        return result;
    }

    @Override
    public String toString()
    {
        return "Manager{" + "name='" + getName() + '\'' + ", experience=" + getExperience() + ", basePayment=" + getBasePayment() + ", coefficient=" + coefficient + '}';
    }
}
