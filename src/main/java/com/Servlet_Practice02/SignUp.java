package com.Servlet_Practice02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// We remove @WebServlet because we are using web.xml for mapping
public class SignUp extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 1. Capture manual values from HTML form
        String name = request.getParameter("uName");
        String email = request.getParameter("uEmail");
        String password = request.getParameter("uPass");

        try {
            // 2. Load the MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. Connect to ResortManagementDB with your password
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ResortManagementDB", "root", "Snehal@18");

            // 4. SQL to insert into your 'users' table
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            // 5. Execute and Redirect
            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Registration Success: " + name);
                // Redirect back to home.html as you requested
                response.sendRedirect("home.html");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            // If database fails, go back to SignUp page
            response.sendRedirect("SignUp.html");
        }
    }
}