package com.softserve.itacademy.stage4.ex2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyUtils {
    public static class Student {
        private int id;
        private String name;
        // Constructor, metthods, Code

        public Student(final int id, final String name)
        {
            this.id = id;
            this.name = name;
        }

        public int getId()
        {
            return id;
        }

        public String getName()
        {
            return name;
        }

        @Override
        public boolean equals(final Object o)
        {
            if (o == this) {
                return true;
            }
            if (o == null || o.getClass() != this.getClass()) {
                return false;
            }

            Student guest = (Student) o;
            return id == guest.id && (name == guest.name || (name != null && name.equals(guest.name)));
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + id;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public String toString()
        {
            return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }
    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        // Code
        Set<Student> studentSet1 = new HashSet<>();
        Set<Student> studentSet2 = new HashSet<>();
        studentSet1.addAll(list1);
        for(Student student: list2) {
            if (student != null && !studentSet1.add(student)) studentSet2.add(student);
        }
        return studentSet2;
    }
}
