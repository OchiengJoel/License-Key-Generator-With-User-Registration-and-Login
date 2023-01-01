/*
package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetCon {

    public static Connection getCon() {

        Connection con= null;

        try {
            Class.forName(DBIntializer.DRIVER);
            con = DriverManager.getConnection(DBIntializer.CON_STRING, DBIntializer.USERNAME, DBIntializer.PASSWORD);
            //System.out.println("connection created==========================");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            System.out.println("Exception in GetCon");
        }


    return con;

}
}
*/
