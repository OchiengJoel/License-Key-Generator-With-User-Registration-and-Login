package com.web;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;


@WebServlet(name = "login2", urlPatterns = {"/login2"})
public class Login2Servlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get the base URL, username, and password from the request
        String baseUrl = req.getParameter("baseUrl");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            // Construct the full URL for the login endpoint
            String loginEndpoint = baseUrl + "/api/auth/login";
            URL url = new URL(loginEndpoint);

            // Create an HttpURLConnection for the login request
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Set the username and password as request parameters
            String requestParams = "username=" + username + "&password=" + password;
            conn.getOutputStream().write(requestParams.getBytes());

            // Read the response from the login request
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse the response as a JSON object

           // JsonObject jsonResponse = new JsonObject(response.toString());
          //  JsonObject


            JsonObject jsonResponse = new JsonObject() {
                @Override
                public ValueType getValueType() {
                    return null;
                }

                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean containsKey(Object key) {
                    return false;
                }

                @Override
                public boolean containsValue(Object value) {
                    return false;
                }

                @Override
                public JsonValue get(Object key) {
                    return null;
                }

                @Override
                public JsonValue put(String key, JsonValue value) {
                    return null;
                }

                @Override
                public JsonValue remove(Object key) {
                    return null;
                }

                @Override
                public void putAll(Map<? extends String, ? extends JsonValue> m) {

                }

                @Override
                public void clear() {

                }

                @Override
                public Set<String> keySet() {
                    return null;
                }

                @Override
                public Collection<JsonValue> values() {
                    return null;
                }

                @Override
                public Set<Entry<String, JsonValue>> entrySet() {
                    return null;
                }

                @Override
                public JsonArray getJsonArray(String s) {
                    return null;
                }

                @Override
                public JsonObject getJsonObject(String s) {
                    return null;
                }

                @Override
                public JsonNumber getJsonNumber(String s) {
                    return null;
                }

                @Override
                public JsonString getJsonString(String s) {
                    return null;
                }

                @Override
                public String getString(String s) {
                    return null;
                }

                @Override
                public String getString(String s, String s1) {
                    return null;
                }

                @Override
                public int getInt(String s) {
                    return 0;
                }

                @Override
                public int getInt(String s, int i) {
                    return 0;
                }

                @Override
                public boolean getBoolean(String s) {
                    return false;
                }

                @Override
                public boolean getBoolean(String s, boolean b) {
                    return false;
                }

                @Override
                public boolean isNull(String s) {
                    return false;
                }
            };

            // Check if the login was successful
            boolean loginSuccessful = jsonResponse.getBoolean("success");
            String token = null;
            if (loginSuccessful) {
                token = jsonResponse.getString("token");
            }

            // If login was successful, store the token in a session variable
            if (token != null) {
                HttpSession session = req.getSession();
                session.setAttribute("token", token);
                resp.sendRedirect("generatelicense.jsp");
            }
        } catch (MalformedURLException ex) {
            // Handle malformed URL exception
        } catch (IOException ex) {
            // Handle IO exception
        }

        //super.doPost(req, resp);
    }
}
