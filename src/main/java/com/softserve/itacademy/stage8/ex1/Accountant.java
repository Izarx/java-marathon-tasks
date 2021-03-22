package com.softserve.itacademy.stage8.ex1;

import java.util.function.BinaryOperator;

public class Accountant {

    public static int sum(int x, int y) {
        ParallelCalculator run = new ParallelCalculator(Integer::sum, x, y);
        Thread thread = new Thread(run);
        thread.start();
        try
        {
            thread.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        return run.result;
    }

}
