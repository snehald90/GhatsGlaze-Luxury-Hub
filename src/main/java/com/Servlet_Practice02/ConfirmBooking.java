package com.Servlet_Practice02;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConfirmBooking extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomType = request.getParameter("roomType");
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Using your verified password from the Nandini registration log
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ResortManagementDB", "root", "Snehal@18");

            String sql = "INSERT INTO bookings (room_type, check_in, check_out) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, roomType);
            ps.setString(2, checkIn);
            ps.setString(3, checkOut);

            int result = ps.executeUpdate();
            if (result > 0) {
                response.sendRedirect("home.html?status=booked");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("home.html?status=error");
        }
    }
}