package com.softserve.itacademy.stage4.ex6;

import java.util.Comparator;

public class DeveloperComparator implements Comparator<Developer> {

    @Override
    public int compare(final Developer o1, final Developer o2)
    {
        if (o1 != null && o2 != null) {
            if ((o1.name != null && o2.name != null) && !o2.name.equals(o1.name)) {
                return o1.name.compareTo(o2.name);
            }
            else if (o2.age != o1.age) {
                return o1.age - o2.age;
            }
            else if (o1.getSalary() != o2.getSalary()) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
            else return o1.getLevel().compareTo(o2.getLevel());
        }
        else return 1;
    }
}
