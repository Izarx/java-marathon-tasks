package com.softserve.itacademy.stage6.ex2;

import java.util.Arrays;
import java.util.function.Consumer;

public class App {

    static Consumer<double[]> cons = doubles -> {
        for(int i = 0; i < doubles.length; i++)
        {
            doubles[i] = doubles[i] > 2 ? doubles[i] * 0.8 : doubles[i] * 0.9;
        }
    };

    public static double[] getChanged(double[] initialArray, Consumer<double[]> consumer) {
        double[] doubles = Arrays.copyOf(initialArray, initialArray.length);
        consumer.accept(doubles);
        return doubles;
    }

    public static void main(String[] args)
    {
        double[] d1 = new double[]{1, 2, 3, 5.01, 8.3, 9.06};
        double[] d2 = getChanged(d1, cons);
        Arrays.stream(d2).forEach(System.out::println);
    }
}