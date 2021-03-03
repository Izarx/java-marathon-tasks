package com.softserve.itacademy.stage2.ex3;

public class Student extends Person {

    private String studyPlace;
    private int studyYears;

    public Student(final String name, final String studyPlace, final int studyYears)
    {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace()
    {
        return studyPlace;
    }

    public int getStudyYears()
    {
        return studyYears;
    }

    @Override
    public boolean equals(final Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof Student))
        {
            return false;
        }
        if(!super.equals(o))
        {
            return false;
        }
        Student student = (Student) o;
        return getName().equals(student.getName()) && studyPlace.equals(student.getStudyPlace()) && studyYears == student.getStudyYears();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((studyPlace == null) ? 0 : studyPlace.hashCode());
        result = prime * result + studyYears;
        return result;
    }

    @Override
    public String toString()
    {
        return "Student{" + "name='" + getName() + '\'' + ", studyPlace='" + studyPlace + '\'' + ", studyYears=" + studyYears + '}';
    }
}
