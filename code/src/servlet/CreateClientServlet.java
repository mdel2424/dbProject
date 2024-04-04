package servlet;

import java.io.IOException;
import java.sql.Date;

import dao.ClientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Client;

@WebServlet("/createClient")
public class CreateClientServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Client client = new Client();

        client.setFullName(request.getParameter("fullName"));
        client.setAddress(request.getParameter("address"));
        client.setSsn(Integer.parseInt(request.getParameter("ssn")));

        client.setRegistrationDate(new Date(System.currentTimeMillis()));;

        ClientDAO clientDAO = new ClientDAO();

        boolean success = clientDAO.insertClient(client);
    }

}
