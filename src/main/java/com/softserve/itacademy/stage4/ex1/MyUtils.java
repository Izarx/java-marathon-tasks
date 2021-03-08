package com.softserve.itacademy.stage4.ex1;

import java.util.*;

public class MyUtils {

    public Map<String, List<String>> createNotebook(Map<String, String> phones) {

        Map<String, List<String>> noteBook = new HashMap<>();

        for (Map.Entry<String, String> pair : phones.entrySet()) {
            List<String> phoneNumbers = noteBook.get(pair.getValue());
            if (phoneNumbers != null) {
                phoneNumbers.add(pair.getKey());
                noteBook.put(pair.getValue(), phoneNumbers);
            }
            else {
                phoneNumbers = new ArrayList<>();
                phoneNumbers.add(pair.getKey());
                noteBook.put(pair.getValue(), phoneNumbers);
            }
        }

        return noteBook;
    }
}
