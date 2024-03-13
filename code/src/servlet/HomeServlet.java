package servlet;

import dao.HotelChainDAO;
import model.HotelChain;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    private HotelChainDAO hotelChainDAO = new HotelChainDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        List<HotelChain> hotelChains = hotelChainDAO.getAllHotelChains(); 
        for (HotelChain hC: hotelChains) {
            response.getWriter().write(hC.getHQAddress()+"  haha   \n");
        }

    }
}
