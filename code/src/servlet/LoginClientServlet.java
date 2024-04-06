package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import dao.ClientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Client;

public class LoginClientServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

        Client client = new Client();

        client.setFullName(request.getParameter("fullName"));
        client.setAddress(request.getParameter("address"));
        client.setSsn(Integer.parseInt(request.getParameter("ssn")));

        client.setRegistrationDate(new Date(System.currentTimeMillis()));;

        ClientDAO clientDAO = new ClientDAO();

        boolean success = clientDAO.insertClient(client);

        PrintWriter out = response.getWriter();
        out.println(success); 

    }

    
}
