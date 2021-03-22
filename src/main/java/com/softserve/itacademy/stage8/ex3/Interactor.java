package com.softserve.itacademy.stage8.ex3;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Interactor {
    int x;

    public void serve(UnaryOperator<Integer> uo, int initializer)throws InterruptedException{
        //your implementation here
        System.out.println("Serving thread running");
        System.out.println("Serving thread initializes the key");
    }

    public void consume(BinaryOperator<Integer> bo, int operand2)throws InterruptedException{
        //your implementation here
    }
}
