package com.softserve.itacademy.stage2.ex5;

import java.util.ArrayList;
import java.util.List;

public class MyUtils {

    public double sumPerimeter(List<Figure> firures) {
        List<Figure> originList = new ArrayList<>();
        if (!firures.isEmpty()) {
            for(Figure figure: firures) {
                if (figure != null) originList.add(figure);
            }
        }
        return originList.stream().mapToDouble(Figure::getPerimeter).sum();
    }

}
