package com.softserve.itacademy.stage3.ex6;

import java.util.Iterator;
import java.util.Objects;

public class AddressBook implements Iterable {

    private int counter;
    private NameAddressPair[] addressBook;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {
        return true;
    }

    public String read(String firstName, String lastName) {
        return null;
    }

    public boolean update(String firstName, String lastName, String address) {
        return true;
    }

    public boolean delete(String firstName, String lastName) {
        return true;
    }

    public int size() {
        return 0;
    }

    public void sortedBy(SortOrder order) {}

    @Override
    public Iterator iterator()
    {
        return null;
    }

    private static class NameAddressPair {

        private Person person;
        private String address;

        private NameAddressPair(final Person person, final String address)
        {
            this.person = person;
            this.address = address;
        }

        private static class Person {

            private String firstName;
            private String lastName;

            private Person(final String firstName, final String lastName)
            {
                this.firstName = firstName;
                this.lastName = lastName;
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
                return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
            }

            @Override
            public int hashCode()
            {
                return Objects.hash(firstName, lastName);
            }
        }

    }

    private class AddressBookIterator implements Iterator {

        private int counter = 0;

        @Override
        public boolean hasNext()
        {
            return false;
        }

        @Override
        public String next()
        {
            return null;
        }
    }
}
