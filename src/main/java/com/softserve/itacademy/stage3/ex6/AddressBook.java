package com.softserve.itacademy.stage3.ex5;

import java.util.Iterator;

public class AddressBook implements Iterable {

    private int counter;
    private NameAddressPair[] addressBook;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    @Override
    public Iterator iterator()
    {
        return null;
    }

    private static class NameAddressPair {



        private static class Person {
            
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
