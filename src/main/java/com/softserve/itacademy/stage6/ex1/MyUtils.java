package com.softserve.itacademy.stage6.ex1;

import java.util.Arrays;
import java.util.function.Predicate;

public class MyUtils {

        public static int getCount( int[] array, Predicate<Integer> functionalInterface ) {
            return (int) Arrays.stream(array).filter(functionalInterface::test).count();
        }

}
