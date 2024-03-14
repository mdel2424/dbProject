package servlet;

import dao.HotelChainDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

// This WebServlet will be called by the js in index.html, which will return the json formatted table view
@WebServlet("/getData")
public class DataServlet extends HttpServlet {
    private HotelChainDAO hotelChainDAO;
    public void init() {
        hotelChainDAO = new HotelChainDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(hotelChainDAO.getAllHotelChainsJson());
        out.flush();
    }
}
