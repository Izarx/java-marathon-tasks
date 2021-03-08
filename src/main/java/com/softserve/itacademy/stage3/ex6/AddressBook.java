package com.softserve.itacademy.stage3.ex6;

import java.util.*;

public class AddressBook implements Iterable {

    private int counter = 0;
    private NameAddressPair[] addressBook;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {

        if (size() != 0 && counter == addressBook.length) {
            NameAddressPair[] newAddressBook = new NameAddressPair[size() * 2];
            System.arraycopy(addressBook, 0, newAddressBook, 0, size());
            addressBook = newAddressBook;
        }

        NameAddressPair.Person personCreated = new NameAddressPair.Person(firstName, lastName);
        int i = 0;
        for (NameAddressPair pair: addressBook) {
            if (pair!= null && pair.person.equals(personCreated)) i++;
        }
        if (i == 0) {
            addressBook [counter ++] = new NameAddressPair(personCreated, address);
            return true;
        }
        return false;
    }

    public String read(String firstName, String lastName) {
        String address = null;
        NameAddressPair.Person personRead = new NameAddressPair.Person(firstName, lastName);
        for(NameAddressPair pair: addressBook) {
            if (pair!= null && pair.person.equals(personRead))
                address = pair.address;
        }
        return address;
    }

    public boolean update(String firstName, String lastName, String address) {
        NameAddressPair.Person personUpdated = new NameAddressPair.Person(firstName, lastName);
        for(NameAddressPair pair : addressBook) {
            if (pair!= null && pair.person.equals(personUpdated)) {
                pair.address = address;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        NameAddressPair.Person personDeleted = new NameAddressPair.Person(firstName, lastName);
        NameAddressPair[] newAddressBook = new NameAddressPair[size()];
        boolean result = false;
        int i = 0;

        for(NameAddressPair pair : addressBook)
        {
            if(pair != null && pair.person.equals(personDeleted))
            {
                pair = null;
                result = true;
                counter --;
            }
            else if(pair != null)
            {
                newAddressBook[i++] = pair;
            }
        }

        addressBook = newAddressBook;

        return result;
    }

    public int size() {
        return counter;
    }

    public void sortedBy(SortOrder order) {

        if (order.equals(SortOrder.ASC)) {
            Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
                @Override
                public int compare(final NameAddressPair o1, final NameAddressPair o2)
                {
                    if (o1 != null && o2 != null) {
                        if (!o2.person.firstName.equals(o1.person.firstName)) {
                            return o1.person.firstName.compareTo(o2.person.firstName);
                        }
                        else {
                            return o1.person.lastName.compareTo(o2.person.lastName);
                        }
                    }
                    else return 1;
                }
            });
        }
        else {
            Arrays.sort(addressBook, new Comparator<NameAddressPair>(){

                @Override
                public int compare(final NameAddressPair o1, final NameAddressPair o2)
                {
                    if (o1 != null && o2 != null) {
                        if (!o2.person.firstName.equals(o1.person.firstName)) {
                            return o2.person.firstName.compareTo(o1.person.firstName);
                        }
                        else {
                            return o2.person.lastName.compareTo(o1.person.lastName);
                        }
                    }
                    else return 1;
                }
            } );
        }
    }

    @Override
    public Iterator iterator()
    {
        return new AddressBookIterator();
    }

     private static class NameAddressPair {

        private final Person person;
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

        @Override
        public String toString()
        {
            return String.format("First name: %s, Last name: %s, Address: %s", person.firstName, person.lastName, address);
        }
    }

    private class AddressBookIterator implements Iterator {

        private int counter = 0;

        @Override
        public boolean hasNext()
        {
            return counter < size() && addressBook[counter] != null;
        }

        @Override
        public String next()
        {
            NameAddressPair pair = addressBook[counter++];
            return String.format("First name: %s, Last name: %s, Address: %s", pair.person.firstName, pair.person.lastName, pair.address);
        }
    }
}
