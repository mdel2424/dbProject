package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;
import dao.BookingDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Booking;

@WebServlet("/createBooking")
public class CreateBookingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            int clientId = Integer.parseInt(request.getParameter("clientId"));
            Date startDate = Date.valueOf(request.getParameter("startDate")); // Expected format: yyyy-mm-dd
            Date endDate = Date.valueOf(request.getParameter("endDate")); // Expected format: yyyy-mm-dd
            int roomId = ThreadLocalRandom.current().nextInt(1, 201); // Randomly assigns a room ID between 1 and 200
            
            Booking booking = new Booking();
            booking.setStatus("Reserved");
            booking.setStartDate(startDate);
            booking.setEndDate(endDate);
            booking.setRoomId(roomId);
            booking.setClientId(clientId);
            
            BookingDAO bookingDAO = new BookingDAO();
            boolean result = bookingDAO.insertBooking(booking);
            
            PrintWriter out = response.getWriter();
            if (result) {
                out.println("{\"status\": \"success\"}");
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                out.println("{\"status\": \"error\", \"message\": \"Failed to create booking.\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            PrintWriter out = response.getWriter();
            out.println("{\"status\": \"error\", \"message\": \"" + e.getMessage() + "\"}");
        }
    }
}
