package com.Servlet_Practice02;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Get the existing session, but don't create a new one
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            session.invalidate(); // 2. Clear all session data
            System.out.println("User logged out successfully.");
        }
        
        // 3. Send the user back to the login page
        response.sendRedirect("Login.html");
    }
}