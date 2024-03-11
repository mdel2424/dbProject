package com.app.servlet;

import com.app.dao.ClientDAO;
import com.app.model.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
    private ClientDAO clientDAO;

    public void init() {
        this.clientDAO = new ClientDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertClient(request, response);
                    break;
                case "delete":
                    deleteClient(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateClient(request, response);
                    break;
                default:
                    listClients(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void listClients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> listClient = clientDAO.getAllClients();
        request.setAttribute("listClient", listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("client-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Client existingClient = clientDAO.getClient(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client-form.jsp");
        request.setAttribute("client", existingClient);
        dispatcher.forward(request, response);
    }

    private void insertClient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ssn = request.getParameter("ssn");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        // Parse registrationDate from request

        Client newClient = new Client(ssn, fullName, address, registrationDate);
        clientDAO.insertClient(newClient);
        response.sendRedirect("list");
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String ssn = request.getParameter("ssn");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        // Parse registrationDate from request

        Client client = new Client(ssn, fullName, address, registrationDate);
        client.setId(id);
        clientDAO.updateClient(client);
        response.sendRedirect("list");
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        clientDAO.deleteClient(id);
        response.sendRedirect("list");
    }
}
