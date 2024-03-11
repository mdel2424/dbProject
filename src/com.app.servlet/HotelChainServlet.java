package com.app.servlet;

import com.app.dao.HotelChainDAO;
import com.app.model.HotelChain;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/HotelChainServlet")
public class HotelChainServlet extends HttpServlet {
    private HotelChainDAO hotelChainDAO;

    public void init() {
        hotelChainDAO = new HotelChainDAO(); // Assumes you have a default constructor for HotelChainDAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertHotelChain(request, response);
                break;
            case "delete":
                deleteHotelChain(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateHotelChain(request, response);
                break;
            default:
                listHotelChains(request, response);
                break;
        }
    }

    private void listHotelChains(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HotelChain> listHotelChain = hotelChainDAO.getAllHotelChains();
        request.setAttribute("listHotelChain", listHotelChain);
        RequestDispatcher dispatcher = request.getRequestDispatcher("hotelchain-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("hotelchain-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HotelChain existingHotelChain = hotelChainDAO.getHotelChain(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("hotelchain-form.jsp");
        request.setAttribute("hotelChain", existingHotelChain);
        dispatcher.forward(request, response);
    }

    private void insertHotelChain(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Parse and validate input data
        String name = request.getParameter("name");
        // Create a new HotelChain object
        // Call the DAO to save the HotelChain object
        response.sendRedirect("list");
    }

    private void updateHotelChain(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Parse and validate input data
        int id = Integer.parseInt(request.getParameter("id"));
        // Update the HotelChain object
        // Call the DAO to update the HotelChain object
        response.sendRedirect("list");
    }

    private void deleteHotelChain(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        hotelChainDAO.deleteHotelChain(id);
        response.sendRedirect("list");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
