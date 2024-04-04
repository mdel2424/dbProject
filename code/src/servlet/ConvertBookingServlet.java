package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DBConnection;

@WebServlet("/convertBooking")
public class ConvertBookingServlet extends HttpServlet {
    
    private Connection connection;
    
    public ConvertBookingServlet() {
        this.connection = DBConnection.getConnection();
        if (this.connection != null) {
            System.out.println("Database is connected.");
        } else {
            System.out.println("Database not connected.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "UPDATE booking SET \"Status\" = ? WHERE bookingId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "Checked-In");
            preparedStatement.setInt(2, Integer.parseInt(request.getParameter("bookingId")));

            int affectedRows = preparedStatement.executeUpdate();
            
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            
            if (affectedRows > 0) {
                response.getWriter().write("{\"message\": \"Booking updated successfully.\"}");
            } else {
                response.getWriter().write("{\"error\": \"No booking found with provided ID.\"}");
            }
        } catch (NumberFormatException e) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"error\": \"Invalid booking ID format.\"}");
            e.printStackTrace();
        } catch (SQLException e) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"error\": \"An error occurred while updating the booking.\"}");
            e.printStackTrace();
        }
    }
}
