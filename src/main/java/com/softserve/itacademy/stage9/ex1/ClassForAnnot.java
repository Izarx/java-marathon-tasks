package com.softserve.itacademy.stage9.ex1;

public class ClassForAnnot {
    @CamelCase
    public static void example() {
    }

    @CamelCase
    public void Example() {
    }

    public static void main(String args[]) {
        System.out.println(new CheckCamelCase().checkAndPrint(Class1.class));
    }
}
