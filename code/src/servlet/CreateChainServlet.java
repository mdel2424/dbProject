package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import dao.ClientDAO;
import dao.HotelChainDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HotelChain;

@WebServlet("/createChain")
public class CreateChainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HotelChain hotelChain = new HotelChain();
    
        hotelChain.setChainId(Integer.parseInt(request.getParameter("id")));
        hotelChain.setHotelChainName(request.getParameter("name"));
        hotelChain.setHQAddress(request.getParameter("locationHQ"));
        hotelChain.setNHotels(Integer.parseInt(request.getParameter("numHotels")));
        hotelChain.setContactEmails(request.getParameter("email"));
        hotelChain.setPhoneNumber(request.getParameter("phoneNum"));

        HotelChainDAO hotelChainDAO = new HotelChainDAO();

        hotelChainDAO.insertHotelChain(hotelChain);
    }

    

}