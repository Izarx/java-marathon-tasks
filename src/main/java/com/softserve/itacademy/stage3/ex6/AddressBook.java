package com.softserve.itacademy.stage3.ex6;

import java.util.*;

public class AddressBook implements Iterable {

    private int counter = 0;
    private NameAddressPair[] addressBook;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {
        NameAddressPair.Person personCreated = new NameAddressPair.Person(firstName, lastName);
        int i = 0;
        for (NameAddressPair pair: addressBook) {
            if (pair.person.equals(personCreated)) i++;
        }
        if (i == 0) {
            Arrays.asList(addressBook).add(new NameAddressPair(personCreated, address));
            counter++;
            return true;
        }
        return false;
    }

    public String read(String firstName, String lastName) {
        String address = "-";
        NameAddressPair.Person personRead = new NameAddressPair.Person(firstName, lastName);
        for(NameAddressPair pair: addressBook) {
            if (pair.person.equals(personRead)) address = pair.address;
        }
        return String.format("(%s, %s) => %s", firstName, lastName, address);
    }

    public boolean update(String firstName, String lastName, String address) {
        NameAddressPair.Person personUpdated = new NameAddressPair.Person(firstName, lastName);
        for(NameAddressPair pair : addressBook) {
            if (pair.person.equals(personUpdated)) {
                pair.address = address;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        NameAddressPair.Person personDeleted = new NameAddressPair.Person(firstName, lastName);
        for(NameAddressPair pair : addressBook) {
            if (pair.person.equals(personDeleted)) {
                Arrays.asList(addressBook).remove(pair);
                counter--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return addressBook.length;
    }

    public void sortedBy(SortOrder order) {
        switch(order) {
            case ASC:
                Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
                    @Override
                    public int compare(final NameAddressPair o1, final NameAddressPair o2)
                    {
                        if (!o1.person.firstName.equals(o2.person.firstName)) {
                            return o2.person.firstName.compareTo(o1.person.firstName);
                        }
                        else {
                            return o2.person.lastName.compareTo(o1.person.lastName);
                        }
                    }
                });
            case DESC:
                Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
                    @Override
                    public int compare(final NameAddressPair o1, final NameAddressPair o2)
                    {
                        if (!o1.person.firstName.equals(o2.person.firstName)) {
                            return o2.person.firstName.compareTo(o1.person.firstName);
                        }
                        else {
                            return o2.person.lastName.compareTo(o1.person.lastName);
                        }
                    }
                }.reversed());
        }
    }

    @Override
    public Iterator iterator()
    {
        return new AddressBookIterator();
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
