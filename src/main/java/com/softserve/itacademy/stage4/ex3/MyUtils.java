package com.softserve.itacademy.stage4.ex3;

import java.util.*;

public class MyUtils {
    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        // Code
        Set<String> setList = new HashSet<>();
        Set<String> setMap = new HashSet<>();

        if (list != null) setList.addAll(list);
        if (map != null) setMap.addAll(map.values());

        if (setList.equals(setMap)) return true;

        return false;
    }

    public static void main(String[] args)
    {
        Map<String, String> map1 = new HashMap<>();
        map1.put("1", "aa");
        map1.put("2", "bb");
        map1.put("3", "cc");
        map1.put("4", "aa");
        map1.put("5", "cc");

        List<String> list1 = new ArrayList<>();
        list1.add("aa");
        list1.add("bb");
        list1.add("aa");
        list1.add("cc");

        System.out.println(new MyUtils().listMapCompare(list1, map1));
    }
}
