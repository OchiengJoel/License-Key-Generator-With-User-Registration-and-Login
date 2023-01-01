/*
package com.utils;

import com.model.LoginBean;
import com.utils.GetCon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {

    public String authenticateUser(LoginBean loginBean){

        String userName= loginBean.getUserName();
        String password = loginBean.getPassword();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";
        String roleDB = "";

        try{
           connection = GetCon.getCon();
           statement = connection.createStatement();
           resultSet = statement.executeQuery("select username,password,role from users");

           while(resultSet.next()){
               if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
                   return "Admin_Role";
               else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals(""))
                   return "User_Role";

           }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Invalid User Credentials";
    }
}
*/
