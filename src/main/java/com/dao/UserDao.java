package com.dao;

import com.model.User;
import com.utils.DBCon;
import com.utils.Validate;

import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private static final String SQL_SELECT_BY_ID ="SELECT * FROM users WHERE name=? AND email=?";
    private static final String SQL_INSERT_USER = "INSERT INTO users(name, email, password, role) VALUES(?, ?, ?, ?)";



    public String registerUser(User userRegister) {
        String name = userRegister.getName();
        String email = userRegister.getEmail();
        String password = userRegister.getPassword();
        String role = userRegister.getRole();

        Connection con = null;
        PreparedStatement preparedStatement = null;
        try
        {
            con = DBCon.createConnection();
            String query = "insert into users(id,name,email,password,role) values (NULL,?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, role);

            int i= preparedStatement.executeUpdate();

            if (i!=0)  //Just to ensure data has been inserted into the database
                return "SUCCESS";
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.

    }

    public User loginUser(String username, String password) throws ServletException {
        User user = null;

        Connection conn = DBCon.createConnection();
        //Check if username and password match what is in db
        String sql = "SELECT * from users WHERE email = ? and password = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // If a matching record is found, return true
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole("role");

                //return true;
            }
        }catch (SQLException e) {
            throw new ServletException("Error Accessing The Database", e);
        }
        // If no matching record is found, return false
        return user;
    }







    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   /* public int validate(User user) {

        int r =0;

        //Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection connection = DBCon.getConnection();

        try {

            ps = connection.prepareStatement(SQL_SELECT_BY_ID);
            ps.setString(1, user.getName());
            ps.setString(2,user.getEmail());
            ps.setString(3, user.getPassword());
            rs = ps.executeQuery();

            while (rs.next()) {
                r = +1;
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }

            if (r == 1) {
                return 1;
            }else {
                return 0;
            }
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
            return 0;
        } //finally {
           // DBCon.closeConnection();
             // DBCon.close(ps);
            //DBCon.close(connection);
        //}
    }

    @Override
    public String insert(User user) {

        Connection conn = null;
        PreparedStatement ps = null;
        String result="Data Entered Successfully";

        try {
            conn = DBCon.getConnection();
            ps = conn.prepareStatement(SQL_INSERT_USER);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.executeUpdate();
        } catch (SQLException ex){
            result="Data Not Entered Successfully";
            ex.printStackTrace(System.out);
        }

        return result;

        *//*finally {
            //DBCon.close(conn);
            DBCon.closeConnection();
        }*//*

    }*/

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
