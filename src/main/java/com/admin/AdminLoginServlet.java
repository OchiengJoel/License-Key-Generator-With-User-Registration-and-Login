/*

package com.admin;

import com.model.*;
import com.utils.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "AdminLoginServlet", urlPatterns = {"/AdminLoginServlet"})
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AdminLoginServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        LoginBean loginBean = new LoginBean();

        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        loginBean.setUserName(userName);
        loginBean.setPassword(password);

        LoginDao loginDao = new LoginDao();

        try{
            String userValidate = loginDao.authenticateUser(loginBean);
            if (userValidate.equals("Admin_Role")) {
                System.out.println("Admins Home");
                HttpSession session = req.getSession();
                session.setAttribute("Admin", userName);
                req.setAttribute("userName", userName);
                req.getRequestDispatcher("/manageUserAdmin.jsp").forward(req, resp);

            } else if (userValidate.equals("")) {
                System.out.println("Your Home Page");
                HttpSession session = req.getSession();
                session.setAttribute("User", userName);
                req.setAttribute("userName", userName);
                req.getRequestDispatcher("/manageUserAdmin.jsp").forward(req, resp);
                
            }else
            {
                System.out.println("Error message = "+userValidate);
                req.setAttribute("errMessage", userValidate);

                req.getRequestDispatcher("/index2.jsp").forward(req, resp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



if (email.equals("john") && pass.equals("admin")) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username", email);
            out.print("Welcome   " + email);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/manageUserAdmin.jsp");
            requestDispatcher.forward(req, resp);
        }else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/adminSignin.jsp");
            requestDispatcher.forward(req, resp);
        }

        //super.doPost(req, resp);
    }
}

*/
