package com.softserve.itacademy.stage4.ex4;

public class ArrayUtil {
    public static <T> T setAndReturn(T[] array,T t, int i){
        array[i] = t;
        return  t;
    }
}
