package com.softserve.itacademy.stage4.ex1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args)
    {
        Map<String , String> map1 = new HashMap<>();
        map1.put("0967654321", "Petro");
        map1.put("0677654321", "Petro");
        map1.put("0501234567", "Ivan");
        map1.put("0970011223", "Stepan");
        map1.put("0631234567", "Ivan");

        Map<String, List<String>> map2 = new MyUtils().createNotebook(map1);

        for (Map.Entry<String, List<String>> pair : map2.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue().toString());
        }

    }
}
