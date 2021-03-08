package com.softserve.itacademy.stage4.ex5;

public class ArrayUtil {
    static double averageValue (Array<? extends Number> array) {
        double average = 0.0;
        for (int i = 0; i < array.length(); i++) {
            average += array.get(i).doubleValue();
        }
        return average/array.length();
    }
}
