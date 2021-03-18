package com.softserve.itacademy.stage6.ex4;

@FunctionalInterface
public interface DecisionMethod<S, I> {
    boolean method (S s, I i);
}
