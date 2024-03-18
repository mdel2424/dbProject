package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import dao.HotelChainDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/populateData")
public class PopulateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HotelChainDAO hotelChainDao = new HotelChainDAO();
        String jsonData;

        // Create the json response depending on the request
        jsonData = hotelChainDao.getAllHotelChains(); // Method to fetch hotel chains
        
        // Respond with the json object
        PrintWriter out = response.getWriter();
        out.print(jsonData);
        out.flush();
    }
}
