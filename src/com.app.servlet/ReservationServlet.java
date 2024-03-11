package com.app.servlet;

import com.app.dao.ReservationDAO;
import com.app.model.Reservation;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
    private ReservationDAO reservationDAO;

    public void init() {
        reservationDAO = new ReservationDAO(); // Make sure to provide the DAO implementation
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertReservation(request, response);
                    break;
                case "/delete":
                    deleteReservation(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateReservation(request, response);
                    break;
                default:
                    listReservations(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void listReservations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reservation> listReservation = reservationDAO.getAllReservations();
        request.setAttribute("listReservation", listReservation);
        RequestDispatcher dispatcher = request.getRequestDispatcher("reservation-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("reservation-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Reservation existingReservation = reservationDAO.getReservation(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("reservation-form.jsp");
        request.setAttribute("reservation", existingReservation);
        dispatcher.forward(request, response);
    }

    private void insertReservation(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Parse and validate input data
        // Create a Reservation object and fill it with data
        // reservationDAO.insert(reservation);
        response.sendRedirect("list");
    }

    private void updateReservation(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Parse and validate input data
        // Create a Reservation object and fill it with data
        // reservationDAO.update(reservation);
        response.sendRedirect("list");
    }

    private void deleteReservation(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        reservationDAO.deleteReservation(id);
        response.sendRedirect("list");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
