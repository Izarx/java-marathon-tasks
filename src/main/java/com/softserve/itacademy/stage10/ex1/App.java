package com.softserve.itacademy.stage10.ex1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
