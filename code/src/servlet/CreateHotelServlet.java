package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import dao.HotelDAO;
import dao.HotelChainDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Hotel;

@WebServlet("/createHotel")
public class CreateHotelServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Hotel hotel = new Hotel();
    
        hotel.setHotelName(request.getParameter("hotelName"));
        hotel.setChainId(Integer.parseInt(request.getParameter("hotelChainId")));
        hotel.setHotelId(Integer.parseInt(request.getParameter("hotelId")));
        hotel.setAddress(request.getParameter("hotelAddress"));
        hotel.setNRooms(Integer.parseInt(request.getParameter("hotelNumberRooms")));
        hotel.setContactEmails(request.getParameter("hotelContactEmail"));
        hotel.setPhoneNumber(request.getParameter("hotelContactPhone"));

        HotelDAO hotelDAO = new HotelDAO();

        hotelDAO.insertHotel(hotel);
    }

    

}