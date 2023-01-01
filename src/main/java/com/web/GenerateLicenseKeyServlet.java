package com.web;

import com.model.GenerateKey;
import com.utils.DBCon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.*;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "/GenerateLicenseKeyServlet", urlPatterns = {"GenerateLicenseKeyServlet"})
public class GenerateLicenseKeyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String link = req.getParameter("link");
        int days = Integer.parseInt(req.getParameter("days"));

        // Generate a unique license key
        SecureRandom secureRandom = new SecureRandom();
        byte[] licenseKey = new byte[16];
        secureRandom.nextBytes(licenseKey);
        String encodedKey = Base64.getEncoder().encodeToString(licenseKey);

        // Calculate the expiration date based on the provided number of days
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        Date expirationDate = calendar.getTime();

        // Append the license key to the dynamic link
        /*URI fullLink = null;
        try {
            fullLink = new URI(link);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        fullLink = fullLink.resolve("?lkey=" + URLEncoder.encode(encodedKey, "UTF-8"));*/

        // Append the license key to the dynamic link
        /*URL fullLink = null;
        try {
            fullLink = new URL(link);
            fullLink.setQuery(encodedKey);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        String fullLinkString = fullLink.toString();*/

        /*// Append the license key to the dynamic link
        String fullLinkString = String.format("%s?key=%s", link, encodedKey);
        URL fullLink = null;
        try {
            fullLink = new URL(fullLinkString);
        } catch (MalformedURLException e) {
            // Set an attribute with the error message
            req.setAttribute("errorMessage", "Invalid URL: " + e.getMessage());
            // Forward the request back to the JSP page
            req.getRequestDispatcher("generatelicense.jsp").forward(req, resp);
            throw new RuntimeException(e);
        }*/

        // Append the license key to the dynamic link
        String fullLinkString = null;
        try {
            fullLinkString = String.format("%s?key=%s", link, encodedKey);
            URL fullLink = new URL(fullLinkString);
        } catch (MalformedURLException e) {
            // Set an attribute with the error message
            req.setAttribute("errorMessage", "Invalid URL: " + e.getMessage());
            // Forward the request back to the JSP page
            req.getRequestDispatcher("generatelicense.jsp").forward(req, resp);
            return;
        }

        Connection conn = DBCon.createConnection();

        // Connect to database and insert the generated license key and expiration date
        try {
            String sql = "insert into license_keys (id,lkey,link,days,expiration_date) values (NULL,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, encodedKey);
            stmt.setString(2, fullLinkString.toString());
            stmt.setInt(3, days);
            stmt.setDate(4, new java.sql.Date(expirationDate.getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create a LicenseKey object and set its fields
        GenerateKey license = new GenerateKey();
        license.setLkey(encodedKey);
        license.setLink(fullLinkString.toString());
        license.setDays(days);
        license.setExpirationDate(expirationDate);
       ;
        // Forward the request back to the JSP page
        req.setAttribute("license", license);
        req.getRequestDispatcher("generatedkey.jsp").forward(req, resp);


    }
}
