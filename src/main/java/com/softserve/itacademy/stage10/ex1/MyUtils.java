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
                                        "id bigint NOT null AUTO_INCREMENT unique," +
                                        " roleName VARCHAR," +
                                        " PRIMARY KEY ( id ))");
    }
    public void createTableDirections() throws SQLException {
        // code
        statement.executeUpdate("CREATE TABLE Directions(" +
                                        "id bigint NOT null AUTO_INCREMENT unique," +
                                        " directionName VARCHAR," +
                                        " PRIMARY KEY ( id ))");
    }
    public void createTableProjects() throws SQLException {
        // code
        statement.executeUpdate("CREATE TABLE Projects(" +
                                        "id bigint NOT null AUTO_INCREMENT unique," +
                                        " projectName VARCHAR," +
                                        " directionId bigint," +
                                        " PRIMARY KEY ( id )," +
                                        " CONSTRAINT project_direction_id FOREIGN KEY (directionId) REFERENCES Directions(id))");
    }
    public void createTableEmployee() throws SQLException {
        // code
        statement.executeUpdate("CREATE TABLE Employee(" +
                                        "id bigint NOT null AUTO_INCREMENT unique," +
                                        " firstName VARCHAR," +
                                        " roleId bigint," +
                                        " projectId bigint," +
                                        " PRIMARY KEY ( id )," +
                                        " CONSTRAINT employee_role_id FOREIGN KEY (roleId) REFERENCES Roles(id)," +
                                        " CONSTRAINT employee_project_id FOREIGN KEY (projectId) REFERENCES Projects(id))");
    }
    public void dropTable(String tableName) throws SQLException {
        // code
        statement.executeUpdate(String.format("DROP TABLE IF EXISTS %s, CASCADE", tableName));
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
    }
    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        // code
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
        return 0;
    }
    public int getEmployeeId(String firstName) throws SQLException {
        // code
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
        return null;
    }
    public List<String> getAllEmployee() throws SQLException {
        // code
        return null;
    }
    public List<String> getAllDevelopers() throws SQLException {
        // code
        return null;
    }
    public List<String> getAllJavaProjects() throws SQLException {
        // code
        return null;
    }
    public List<String> getAllJavaDevelopers() throws SQLException {
        // code
        return null;
    }
}
