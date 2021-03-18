package com.softserve.itacademy.stage6.ex4;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        int i = 0;
        DecisionMethod<String, Integer> goShopping = (v1, v2) -> v1 == product && v2 > percent;
        for(DecisionMethod<String, Integer> decisionMethod : clients) {
            if (decisionMethod.method(product, percent) == goShopping.method("product1", 10)) i++;
        }
        return i;
    }
}
