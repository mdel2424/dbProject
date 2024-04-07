package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Client;

import java.io.IOException;
import java.io.PrintWriter;

import dao.ClientDAO;

@WebServlet("/createClient")
public class CreateClientServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        Client client = new Client(
            Integer.parseInt(request.getParameter("ssn")),
            request.getParameter("fullName"),
            request.getParameter("email"),
            new java.sql.Date(System.currentTimeMillis())
        );

        ClientDAO clientDAO = new ClientDAO();
        boolean result = clientDAO.insertClient(client);

        PrintWriter out = response.getWriter();
        if(result) {
            out.println("{\"status\": \"success\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("{\"status\": \"error\", \"message\": \"Failed to create user.\"}");
        }
    }
}
