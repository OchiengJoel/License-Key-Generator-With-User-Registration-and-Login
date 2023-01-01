package com.web;

import com.dao.UserDao;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletRegister", urlPatterns = {"/ServletRegister"})
public class ServletRegister extends HttpServlet {

    private static final long serialVersionUID=1L;

    public ServletRegister() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


/*    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        UserDao user = new UserDao();
        String action = request.getParameter("action");

        if(action.equals("register")){
            User p = new User(password);
            String username = request.getParameter("username");
            String email  = request.getParameter("email");

            p.setUsername(username);
            p.setEmail(email);

            user.insert(p);
            request.setAttribute("message","Registered Successfully.");
            request.getRequestDispatcher("register2.jsp").forward(request, response);
        }
    }*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // Create a new user
        User user = new User();

        // Save the user to the database
        //UserDao userDao = new UserDao();
        //userDao.insert(user);


        // Save the user to the database
        User userRegister = new User();
        userRegister.setName(name);
        userRegister.setEmail(email);
        userRegister.setPassword(password);
        userRegister.setRole(role);

        UserDao userDao = new UserDao();

        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String userRegistered = userDao.registerUser(userRegister);

        if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
        {
            //request.getRequestDispatcher("/Home.jsp").forward(request, response);
            response.sendRedirect("index2.jsp");
        }
        else   //On Failure, display a meaningful message to the User.
        {
            request.setAttribute("errMessage", userRegistered);
            //request.getRequestDispatcher("/Register.jsp").forward(request, response);
            response.sendRedirect("register2.jsp");
        }



        // Redirect the user to the login page
        //response.sendRedirect("index2.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
