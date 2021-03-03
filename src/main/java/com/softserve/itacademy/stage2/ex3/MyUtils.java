package com.softserve.itacademy.stage2.ex3;

import java.util.*;

public class MyUtils {

    public List<Person> maxDuration(List<Person> persons) {

        Comparator<Student> comparatorStudent = Comparator.comparing(obj -> obj.getStudyYears());
        Comparator<Worker> comparatorWorker = Comparator.comparing(obj -> obj.getExperienceYears());
        List<Person> maxDuration = new ArrayList<>();
        List<Student> maxDurationStudent = new ArrayList<>();
        List<Worker> maxDurationWorker = new ArrayList<>();
        Map<Person, String> unique = new HashMap<>();

        if (!persons.isEmpty()) {
            for (Person person: persons) {
                if (person != null) {
                    unique.put(person, person.getName());
                }
            }

            for (Map.Entry<Person, String> entry : unique.entrySet()) {
                Person person = entry.getKey();
                if (person!= null & person instanceof Student) {
                    maxDurationStudent.add((Student) person);
                }
                else if(person != null & person instanceof Worker) {
                    maxDurationWorker.add((Worker) person);
                }
            }

            if (!maxDurationWorker.isEmpty())
            {
                for (Worker worker : maxDurationWorker) {
                    if (worker != null & worker.getExperienceYears() == Collections.max(maxDurationWorker, comparatorWorker).getExperienceYears()) {
                        maxDuration.add(worker);
                    }
                }
            }

            if (!maxDurationStudent.isEmpty()) {
                for (Student student: maxDurationStudent) {
                    if (student != null & student.getStudyYears() == Collections.max(maxDurationStudent, comparatorStudent).getStudyYears()) {
                        maxDuration.add(student);
                    }
                }
            }

            return maxDuration;
        }
        return maxDuration;
    }
}
