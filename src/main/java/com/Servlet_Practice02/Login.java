package com.Servlet_Practice02;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("uName");
        String pass = request.getParameter("uPass");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Use your confirmed password: Snehal@18
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ResortManagementDB", "root", "Snehal@18");
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                // SUCCESS: This sends you directly to home.html
                response.sendRedirect("home.html");
            } else {
                // FAILURE: Stay on Login page
                response.sendRedirect("Login.html");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            // IMPORTANT: If database fails, redirect back so you don't get a blank page
            response.sendRedirect("Login.html");
        }
    }
}