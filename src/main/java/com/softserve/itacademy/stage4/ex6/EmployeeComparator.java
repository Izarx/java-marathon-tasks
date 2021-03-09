package com.softserve.itacademy.stage4.ex6;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(final Employee o1, final Employee o2)
    {
        if (o1 != null && o2 != null) {
            if ((o1.name != null && o2.name != null) && !o2.name.equals(o1.name)) {
                return o1.name.compareTo(o2.name);
            }
            else if (o2.age != o1.age) {
                return o1.age - o2.age;
            }
            else return Double.valueOf(o1.getSalary()).compareTo(Double.valueOf(o2.getSalary()));
        }
        else return 1;
    }
}
