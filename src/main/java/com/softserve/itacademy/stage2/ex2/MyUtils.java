package com.softserve.itacademy.stage2.ex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtils {

    public Map<String, Double> averageRating(List<Caffee> caffeeList) {
        Map<String, Double> averageRating = new HashMap<>();
        for(Caffee caffee: caffeeList) {
            String name = caffee.getName();
            double rating = caffee.getRating();
            if (averageRating.get(name) != null) {
                averageRating.put(name, (averageRating.get(name) + rating)/2);
            }
            else {
                averageRating.put(name, rating);
            }
        }
        return averageRating;
    }
}
