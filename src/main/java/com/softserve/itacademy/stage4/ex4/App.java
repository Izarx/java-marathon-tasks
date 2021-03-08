package com.softserve.itacademy.stage4.ex4;

public class App {
    public static void main(String[] args)
    {
        Integer[] numbers = new Integer[3];
        int number = ArrayUtil.<Integer>setAndReturn(numbers, 52, 1);
        System.out.println(number);

        String[] words = new String[3];
        String word = ArrayUtil.<String>setAndReturn(words, "Hello!", 2);
        System.out.println(word);
    }
}
