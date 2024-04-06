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
import model.Client;

@WebServlet("/createClient")
public class CreateClientServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Client client;

        ClientDAO clientDAO = new ClientDAO();

        //gets a client using getClient() with the ssn given in the HTML 
        client = clientDAO.getClient(request.getParameter("ssn"));




    }

    

}
