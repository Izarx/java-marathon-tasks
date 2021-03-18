package com.softserve.itacademy.stage7.ex1;

import java.time.LocalDate;
import java.time.Month;

public class App {

    public static boolean isLeapYear(int year) {

        return LocalDate.of(year, Month.JANUARY, 1).isLeapYear();

    }

}
