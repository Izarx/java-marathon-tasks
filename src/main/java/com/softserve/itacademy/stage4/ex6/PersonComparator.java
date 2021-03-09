package com.softserve.itacademy.stage4.ex6;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(final Person o1, final Person o2)
    {
        if (o1 != null && o2 != null) {
            if ((o1.name != null && o2.name != null) && !o2.name.equals(o1.name)) {
                return o1.name.compareTo(o2.name);
            }
            else {
                return o1.age - o2.age;
            }
        }
        else return 1;
    }
}
