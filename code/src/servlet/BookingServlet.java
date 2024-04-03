package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import dao.BookingSearchDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getBooking")
public class BookingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        // Get the arguments that are passed in the request
        Map<String, String[]> arguments = request.getParameterMap();
        BookingSearchDAO bookingSearchDao = new BookingSearchDAO();
        String jsonData;

        // Create the json response depending on the request
        jsonData = bookingSearchDao.getRoomsFromQuery(arguments); // Method to fetch hotels by chain ID

        // Respond with the json object
        PrintWriter out = response.getWriter();
        out.print(jsonData);
        out.flush();
    }
}
