package com.softserve.itacademy.stage4.ex2;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args)
    {
        List<MyUtils.Student> list1 = new ArrayList<>();
        List<MyUtils.Student> list2 = new ArrayList<>();

        list1.add(new MyUtils.Student(1, "Ivan"));
        list1.add(new MyUtils.Student(2, "Petro"));
        list1.add(new MyUtils.Student(3, null));
        list1.add(new MyUtils.Student(3, "Stepan"));

        list2.add(new MyUtils.Student(3, "Stepan"));
        list2.add(new MyUtils.Student(1, "Ivan"));
        list2.add(new MyUtils.Student(0, null));

        System.out.println(new MyUtils().commonStudents(list1, list2).toString());
    }
}
