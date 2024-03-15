package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import dao.HotelChainDAO;
import dao.HotelDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getData")
public class DataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String hotelChainIdStr = request.getParameter("hotelChainId");
        String daoType = request.getParameter("daoType");
        HotelDAO hotelDao = new HotelDAO();
        HotelChainDAO hotelChainDao = new HotelChainDAO();
        String jsonData;

        if ("hotelChain".equals(daoType)) {
            jsonData = hotelChainDao.getAllHotelChains(); // Method to fetch hotel chains
        } else if (hotelChainIdStr != null && !hotelChainIdStr.isEmpty()) {
            int hotelChainId = Integer.parseInt(hotelChainIdStr);
            jsonData = hotelDao.getHotelsByChainId(hotelChainId); // Method to fetch hotels by chain ID
        } else {
            jsonData = hotelDao.getAllHotels(); // Method to fetch all hotels
        }

        PrintWriter out = response.getWriter();
        out.print(jsonData);
        out.flush();
    }
}
