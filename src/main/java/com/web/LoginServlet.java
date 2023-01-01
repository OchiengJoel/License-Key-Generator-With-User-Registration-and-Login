package com.web;

import com.dao.UserDao;
import com.model.User;
import com.utils.DBCon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Get the username and password from the request
        String username = req.getParameter("email");
        String password = req.getParameter("password");

        UserDao newLogin = new UserDao();
        User user = newLogin.loginUser(username,password);

        if (user!= null) {

            HttpSession session = req.getSession();
            session.setAttribute("loginUser", username);
            resp.sendRedirect("generatelicense.jsp");


        }else {

            // User is not authenticated, show an error message
            req.setAttribute("errorMessage", "Invalid username or password");
            resp.sendRedirect("index2.jsp");
            //System.out.println("User Not Found");
        }

        //System.out.println("</body>");
        //System.out.println("</html>");




        //Validate the login credentials against the database

        /*boolean isValid = validate(username,password);

        if (isValid) {
        // If the login is successful, redirect the user to the home page
            resp.sendRedirect("generatelicense.jsp");
        } else {
            // If the login is unsuccessful, display an error message
            req.setAttribute("errorMessage", "Invalid username or password");
            req.getRequestDispatcher("index2.jsp").forward(req, resp);
        }*/

    }

    /*private boolean validate(String username, String password) {

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
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        // If no matching record is found, return false
        return false;
    }*/
}
