package com.softserve.itacademy.stage6.ex4;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        int i = 0;
        for(DecisionMethod<String, Integer> decisionMethod : clients) {
            if (decisionMethod.method(product, percent)) i++;
        }
        return i;
    }
}
