package com.softserve.itacademy.stage9.ex1;

import java.time.LocalDate;

public class Util {
    public static void review(String className) {
        try
        {
            if(Class.forName(className).isAnnotationPresent(Review.class))
            {
                System.out.println("Class " + className + " was reviewed "
                                            + date(className) + " by "
                                            + Class.forName(className).getAnnotation(Review.class).reviewer()
                                            + ".");
            }
            else
            {
                System.out.println("Class " + className + " isn't marked as Reviewed");
            }
        }
        catch(ClassNotFoundException e) {
            System.out.println("Class " + className + " was not found");
        }
    }

    public static LocalDate date(String className) throws ClassNotFoundException {
        String[] strings = Class.forName(className).getAnnotation(Review.class).date().split("-");
        return Class.forName(className).getAnnotation(Review.class).date().equals("today") ?
                LocalDate.now() :
                LocalDate.of(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2]));
    }
}
