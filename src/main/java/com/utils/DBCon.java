package com.utils;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.*;

public class DBCon {


    public static Connection createConnection()
    {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/EmS"; //MySQL URL followed by the database name
        String username = "root"; //MySQL username
        String password = "Joe2018*"; //MySQL password
        System.out.println("In DBConnection.java class ");

        try
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
            System.out.println("Printing connection object "+con);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }






   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*private static BasicDataSource dataSource;
    private static final String JDBC_URl = "jdbc:mysql://localhost/EmS?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "Joe2018*";

    private final String dbdriver = "com.mysql.jdbc.Driver";

    public void loadDriver(String dbDriver)
    {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

   *//* private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(JDBC_URl, JDBC_USER, JDBC_PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }*//*

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(JDBC_URl, JDBC_USER, JDBC_PASS);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }

   *//* public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}