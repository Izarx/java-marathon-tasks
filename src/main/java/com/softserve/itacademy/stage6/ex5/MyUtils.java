package com.softserve.itacademy.stage6.ex5;

import java.util.Set;
import java.util.function.Predicate;

public class MyUtils {
    static Predicate<Integer> getPredicateFromSet (Set<Predicate<Integer>> predicates) {
        Predicate<Integer> predicate = (p1) -> true;
        for (Predicate<Integer> p : predicates) {
            predicate = predicate.and(p);
        }
        return predicate;
    }
}
