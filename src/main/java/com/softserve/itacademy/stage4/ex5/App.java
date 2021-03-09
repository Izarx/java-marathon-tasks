package com.softserve.itacademy.stage4.ex5;


public class App {
    public static void main(String[] args)
    {
        Array<Long> set1 = new Array<>(new Long[]{Long.valueOf(1), Long.valueOf(2), Long.valueOf(4), Long.valueOf(5)});
        double av1 = ArrayUtil.averageValue(set1);
        System.out.println(av1);
    }

}