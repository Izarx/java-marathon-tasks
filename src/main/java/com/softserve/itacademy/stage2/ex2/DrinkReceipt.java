package com.softserve.itacademy.stage2.ex2;

public interface DrinkReceipt {
    String getName();
    DrinkReceipt addComponent(String componentName, int componentCount);
}
