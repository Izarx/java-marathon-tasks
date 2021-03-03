package com.softserve.itacademy.stage2.ex3;

public class Person {

    private String name;

    public Person(final String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public boolean equals(final Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof Person))
        {
            return false;
        }
        Person person = (Person) o;
        return name.equals(person.getName());
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString()
    {
        return "Person{" + "name='" + name + '\'' + '}';
    }
}
