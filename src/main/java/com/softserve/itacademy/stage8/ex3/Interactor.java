package com.softserve.itacademy.stage8.ex3;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Interactor {
    int x;

    public synchronized void serve(UnaryOperator<Integer> uo, int initializer)throws InterruptedException{
        //your implementation here
        notify();
        System.out.println("Serving thread running");
        System.out.println("Serving thread initializes the key");
        x = uo.apply(initializer);
        System.out.println("key = " + x);
        wait(1000);
        System.out.println("Serving thread resumed");
    }

    public synchronized void consume(BinaryOperator<Integer> bo, int operand2)throws InterruptedException{
        //your implementation here
        wait(3000);
        System.out.println("Consuming thread received the key. key = " + x);
        x = bo.apply(x, operand2);
        System.out.println("Consuming thread changed the key. key = " + x);
    }
}
