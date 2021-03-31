package com.softserve.itacademy.stage10.ex1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;

public class App {
    public static void main(String[] args)
    {
        MyUtils util = new MyUtils();
        try (Connection con = util.createConnection();
             Statement statement = util.createStatement())
        {
            util.createTableRoles();
            util.createTableDirections();
            util.createTableProjects();
            util.createTableEmployee();
            util.insertTableRoles("Developer");
            util.insertTableRoles("DevOps");
            util.insertTableRoles("QS");
            util.insertTableDirections("Java");
            util.insertTableDirections("Python");
            util.insertTableDirections(".NET");
            util.insertTableProjects("Moonlight", "Java");
            util.insertTableProjects("Sun", "Java");
            util.insertTableProjects("Mars", "Python");
            util.insertTableEmployee("Ivan", "Developer", "Moonlight");
            util.insertTableEmployee("Petro", "Developer", "Sun");
            util.insertTableEmployee("Stepan", "Developer", "Mars");
            util.insertTableEmployee("Andriy", "DevOps", "Moonlight");
            util.insertTableEmployee("Olya", "QS", "Sun");
            LocalTime t1 = LocalTime.now();
            util.getAllJavaDevelopers().forEach(System.out::println);
            LocalTime t2 = LocalTime.now();
            System.out.println(t2.getNano() - t1.getNano());
            System.out.println(util.getRoleId("DevOps"));
            util.getAllDirestion().forEach(System.out::println);
            // util.dropTable("Roles");
        }
        catch(SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }
}
