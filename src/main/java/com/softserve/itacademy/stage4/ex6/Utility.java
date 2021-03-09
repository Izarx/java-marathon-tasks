package com.softserve.itacademy.stage4.ex6;

import java.util.Arrays;
import java.util.Comparator;

public class Utility {

    public static <T extends Person> void sortPeople (T [] people, Comparator<? super T> comparator) {
        Arrays.sort(people, comparator);
    }

}
