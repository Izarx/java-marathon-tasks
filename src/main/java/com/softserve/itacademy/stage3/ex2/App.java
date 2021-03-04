package com.softserve.itacademy.stage3.ex2;

public class App {
    public static void main(String[] args)
    {
        for (NameList.Iterator iterator = new NameList().getIterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
}
