package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import dao.DAOFactory;
import dao.GenericDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// This WebServlet will be called by the js in index.html, which will return the json formatted table view
@WebServlet("/getData")
public class DataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String daoType = request.getParameter("daoType");
        GenericDAO dao = DAOFactory.getDAO(daoType); // DAOFactory is a hypothetical class that returns the correct DAO instance based on daoType

        PrintWriter out = response.getWriter();
        out.print(dao.getAllJson());
        out.flush();
    }
}
