package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBConnection;

@WebServlet("/checkSSN")
public class CheckSSNServlet extends HttpServlet {
    private Connection connection;

    public CheckSSNServlet() {
        this.connection = DBConnection.getConnection();
        if (this.connection != null) {
            System.out.println("Database is connected.");
        } else {
            System.out.println("Database not connected.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "SELECT COUNT(*) AS count FROM client WHERE ssn = ?";
        try {
            int ssn = Integer.parseInt(request.getParameter("loginSSN"));
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, ssn);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next() && resultSet.getInt("count") > 0) {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("{\"message\": \"SSN exists.\"}");
                } else {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("{\"error\": \"SSN not found.\"}");
                }
            }
        } catch (NumberFormatException e) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"error\": \"Invalid SSN format.\"}");
            e.printStackTrace();
        } catch (SQLException e) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"error\": \"Database error occurred.\"}");
            e.printStackTrace();
        }
    }
}
