package com.softserve.itacademy.stage2.ex6;

import java.util.*;

public class MyUtils {

    public List<Shape> maxAreas(List<Shape> shapes) {

        Map<Shape, String> uniqueMap = new HashMap<>();
        List<Shape> circles = new ArrayList<>();
        List<Shape> rectangles = new ArrayList<>();
        List<Shape> originList = new ArrayList<>();

        if (!shapes.isEmpty()) {
            shapes.forEach(o -> {
                if (o!=null) uniqueMap.put(o, o.getName());
            });
        }

        uniqueMap.forEach((k,v) -> {
                    if (k instanceof Circle) {
                        circles.add(k);
                    }
                    else if (k instanceof Rectangle) {
                        rectangles.add(k);
                    }
                });

        if (!circles.isEmpty()) originList.addAll(maxAreaShape(circles));
        if (!rectangles.isEmpty()) originList.addAll(maxAreaShape(rectangles));

        return originList;
    }

    public List<Shape> maxAreaShape (List<Shape> shapes) {
        List<Shape> result = new ArrayList<>();
        shapes.forEach(o -> {
            if (o!=null & o.getArea() == Collections.max(shapes, Comparator.comparing(obj -> obj.getArea())).getArea()) result.add(o);
        });
        return result;
    }

}
