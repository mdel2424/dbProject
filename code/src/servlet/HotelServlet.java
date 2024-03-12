package servlet;

import dao.HotelDAO;
import model.Hotel;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/HotelServlet")
public class HotelServlet extends HttpServlet {
    private HotelDAO hotelDAO;

    public void init() {
        hotelDAO = new HotelDAO(); // Assumes you have a default constructor for HotelDAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch (action) {
            case "new":
                // Show new form
                break;
            case "insert":
                // Insert hotel
                break;
            case "delete":
                // Delete hotel
                break;
            case "edit":
                // Show edit form
                break;
            case "update":
                // Update hotel
                break;
            case "list":
            default:
                listHotels(request, response);
        }
    }

    private void listHotels(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Hotel> listHotel = hotelDAO.getAllHotels();
        request.setAttribute("listHotel", listHotel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("hotel-list.jsp");
        dispatcher.forward(request, response);
    }

    // doPost for handling form submissions, such as insert and update
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
