package com.softserve.itacademy.stage2.ex4;

import com.softserve.itacademy.stage2.ex3.Worker;
import com.softserve.itacademy.stage2.ex6.Shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyUtils {

    public List<Employee> largestEmployees(List<Employee> workers) {

        List<Employee> uniqueEmployees  = new ArrayList<>();
        List<Employee> uniqueManagers = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();

        if (!workers.isEmpty()) {
            for(Employee employee: workers) {
                if (employee != null & employee instanceof Manager) {
                    if (!uniqueManagers.contains(employee)) uniqueManagers.add(employee);
                }
                else if (employee != null & employee instanceof Employee){
                    if (!uniqueEmployees.contains(employee)) uniqueEmployees.add(employee);
                }
            }
        }

        if (!uniqueEmployees.isEmpty()) maxExperience(uniqueEmployees).forEach(o -> {
            if (!employeeList.contains(o)) employeeList.add(o);
        });
        if (!uniqueManagers.isEmpty()) maxExperience(uniqueManagers).forEach(o -> {
            if (!employeeList.contains(o)) employeeList.add(o);
        });
        if (!uniqueEmployees.isEmpty()) maxPayment(uniqueEmployees).forEach(o -> {
            if (!employeeList.contains(o)) employeeList.add(o);
        });
        if (!uniqueManagers.isEmpty()) maxPayment(uniqueManagers).forEach(o -> {
            if (!employeeList.contains(o)) employeeList.add(o);
        });

        return employeeList;
    }

    public List<Employee> maxExperience (List<Employee> employees) {
        List<Employee> result = new ArrayList<>();
        employees.forEach(o -> {
            if (o!=null & o.getExperience() == Collections.max(employees, Comparator.comparing(obj -> obj.getExperience())).getExperience()) result.add(o);
        });
        return result;
    }

    public List<Employee> maxPayment (List<Employee> employees) {
        List<Employee> result = new ArrayList<>();
        employees.forEach(o -> {
            if (o!=null & o.getBasePayment() == Collections.max(employees, Comparator.comparing(obj -> obj.getBasePayment())).getBasePayment()) result.add(o);
        });
        return result;
    }

}