package com.softserve.itacademy.stage10.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
        connection = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
        return connection;
    }
    public void closeConnection() throws SQLException {
        // code
        connection.close();
    }
    public Statement createStatement() throws SQLException {
        // code
        statement = connection.createStatement();
        return statement;
    }
    public void closeStatement() throws SQLException {
        // code
        statement.close();
    }
    public void createSchema(String schemaName) throws SQLException {
        // code
        this.schemaName = schemaName;
        statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS " + this.schemaName);
    }
    public void dropSchema() throws SQLException {
        // code
        statement.executeUpdate("DROP SCHEMA " + this.schemaName);
        this.schemaName = null;
    }
    public void useSchema() throws SQLException {
        // code
        statement.executeUpdate("USE " + this.schemaName);
    }
    public void createTableRoles() throws SQLException {
        // code
        statement.executeUpdate("CREATE TABLE Roles(" +
                                        "id SERIAL," +
                                        " roleName VARCHAR," +
                                        " CONSTRAINT rolesPk" +
                                        " PRIMARY KEY (id))");
    }
    public void createTableDirections() throws SQLException {
        // code
        statement.executeUpdate("CREATE TABLE Directions(" +
                                        "id SERIAL," +
                                        " directionName VARCHAR," +
                                        " CONSTRAINT directionsPk" +
                                        " PRIMARY KEY (id))");
    }
    public void createTableProjects() throws SQLException {
        // code
        statement.executeUpdate("CREATE TABLE Projects(" +
                                        "id SERIAL," +
                                        " projectName VARCHAR," +
                                        " directionId BIGINT," +
                                        " CONSTRAINT projectsPk" +
                                        " PRIMARY KEY (id)," +
                                        " CONSTRAINT projectsDirectionsFk" +
                                        " FOREIGN KEY (directionId) REFERENCES Directions(id))");
    }
    public void createTableEmployee() throws SQLException {
        // code
        statement.executeUpdate("CREATE TABLE Employee(" +
                                        "id SERIAL PRIMARY KEY," +
                                        " firstName VARCHAR," +
                                        " roleId BIGINT," +
                                        " projectId BIGINT," +
                                        " CONSTRAINT employeeRolesFk" +
                                        " FOREIGN KEY (roleId) REFERENCES Roles(id)," +
                                        " CONSTRAINT employeeProjectsFk" +
                                        " FOREIGN KEY (projectId) REFERENCES Projects(id))");
    }
    public void dropTable(String tableName) throws SQLException {
        // code
        statement.executeUpdate(String.format("DROP TABLE IF EXISTS %s CASCADE", tableName));
    }
    public void insertTableRoles(String roleName) throws SQLException {
        // code
        statement.executeUpdate(String.format("INSERT INTO Roles (roleName) VALUES ('%s')", roleName));
    }
    public void insertTableDirections(String directionName) throws SQLException {
        // code
        statement.executeUpdate(String.format("INSERT INTO Directions (directionName) VALUES ('%s')", directionName));
    }
    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        // code
        statement.executeUpdate(String.format("INSERT INTO Projects (projectName, directionId)" +
                                                      " VALUES ('%s', '%d')", projectName, getDirectionId(directionName)));
    }
    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        // code
        statement.executeUpdate(String.format("INSERT INTO Employee (firstName, roleId, projectId)" +
                                                      " VALUES ('%s', '%d', '%d')", firstName, getRoleId(roleName), getProjectId(projectName)));
    }
    public int getRoleId(String roleName) throws SQLException {
        // code
        ResultSet setRoles = statement.executeQuery("SELECT id, roleName FROM Roles");
        while(setRoles.next()) {
            if (setRoles.getString("roleName").equals(roleName))
                return setRoles.getInt("id");
        }
        return 0;
    }
    public int getDirectionId(String directionName) throws SQLException {
        // code
        ResultSet setRoles = statement.executeQuery("SELECT id, directionName FROM Directions");
        while(setRoles.next()) {
            if (setRoles.getString("directionName").equals(directionName))
                return setRoles.getInt("id");
        }
        return 0;
    }
    public int getProjectId(String projectName) throws SQLException {
        // code
        ResultSet setRoles = statement.executeQuery("SELECT id, projectName FROM Projects");
        while(setRoles.next()) {
            if (setRoles.getString("projectName").equals(projectName))
                return setRoles.getInt("id");
        }
        return 0;
    }
    public int getEmployeeId(String firstName) throws SQLException {
        // code
        ResultSet setRoles = statement.executeQuery("SELECT id, firstName FROM Employee");
        while(setRoles.next()) {
            if (setRoles.getString("firstName").equals(firstName))
                return setRoles.getInt("id");
        }
        return 0;
    }
    public List<String> getAllRoles() throws SQLException {
        // code
        List<String> listRoles = new ArrayList<>();
        ResultSet setRoles = statement.executeQuery("SELECT roleName " +
                                                            "FROM Roles");
        while(setRoles.next()) {
            listRoles.add(setRoles.getString("roleName"));
        }
        return listRoles;
    }
    public List<String> getAllDirestion() throws SQLException {
        // code
        List<String> listDirections = new ArrayList<>();
        ResultSet setDirections = statement.executeQuery("SELECT directionName " +
                                                            "FROM Directions");
        while(setDirections.next()) {
            listDirections.add(setDirections.getString("directionName"));
        }
        return listDirections;
    }
    public List<String> getAllProjects() throws SQLException {
        // code
        List<String> listProjects = new ArrayList<>();
        ResultSet setProjects = statement.executeQuery("SELECT projectName " +
                                                               "FROM Projects");
        while(setProjects.next()) {
            listProjects.add(setProjects.getString("projectName"));
        }
        return listProjects;
    }
    public List<String> getAllEmployee() throws SQLException {
        // code
        List<String> listEmployees = new ArrayList<>();
        ResultSet setEmployees = statement.executeQuery("SELECT firstName " +
                                                               "FROM Employee");
        while(setEmployees.next()) {
            listEmployees.add(setEmployees.getString("firstName"));
        }
        return listEmployees;
    }
    public List<String> getAllDevelopers() throws SQLException {
        // code
        List<String> listDevelopers = new ArrayList<>();
        ResultSet setDevelopers = statement.executeQuery(String.format("SELECT firstName " +
                                                                               "FROM Employee " +
                                                                               "WHERE roleId = %s", getRoleId("Developer")));
        while(setDevelopers.next()){
            listDevelopers.add(setDevelopers.getString("firstName"));
        }
        return listDevelopers;
    }
    public List<String> getAllJavaProjects() throws SQLException {
        // code
        List<String> listJavaProjects = new ArrayList<>();
        ResultSet setJavaProjects =
                statement.executeQuery(String.format("SELECT projectName " +
                                                             "FROM Projects " +
                                                             "WHERE directionId = %s", getDirectionId("Java")));
        while(setJavaProjects.next()){
            listJavaProjects.add(setJavaProjects.getString("projectName"));
        }
        return listJavaProjects;
    }
    public List<String> getAllJavaDevelopers() throws SQLException {
        // code
        List<String> listJavaDevelopers = new ArrayList<>();
        ResultSet setJavaDevelopers =
                statement.executeQuery(String.format("SELECT Employee.firstName,  " +
                                                             "FROM Employee " +
                                                             "INNER JOIN Projects ON projectId = Projects.id " +
                                                             "INNER JOIN Directions ON Directions.id = Projects.directionId " +
                                                             "WHERE Projects.directionId = %s " +
                                                             "AND Employee.roleId = %s", getDirectionId("Java")
                                                              , getRoleId("Developer")));
        while(setJavaDevelopers.next()) {
            listJavaDevelopers.add(setJavaDevelopers.getString("firstName"));
        }
        return listJavaDevelopers;
    }
}