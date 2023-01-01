package com.web;

import com.model.GenerateKey;
import com.utils.DBCon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LicenseListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Create DB Connection
        Connection connection = DBCon.createConnection();

        List <GenerateKey> licenseList = new ArrayList<>();

        try {

            String sql = "SELECT * FROM license_keys";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                GenerateKey obj = new GenerateKey();
                obj.setLkey(rs.getString("lkey"));
                obj.setLink(rs.getString("link"));
                obj.setDays(rs.getInt("days"));
                obj.setExpirationDate(rs.getDate("expiration_date"));
                licenseList.add(obj);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        req.setAttribute("licenseList", licenseList);
        // Forward the request to the JSP page
        RequestDispatcher dispatcher = req.getRequestDispatcher("generatedkey.jsp");
        dispatcher.forward(req, resp);

        // super.doGet(req, resp);
    }
}
