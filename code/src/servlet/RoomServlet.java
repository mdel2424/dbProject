package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import dao.RoomSearchDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Text;

@WebServlet("/getRoom")
public class RoomServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        // Get the arguments that are passed in the request
        Map<String, String[]> arguments = request.getParameterMap();
        RoomSearchDAO roomSearchDao = new RoomSearchDAO();
        String jsonData;

        // Create the json response depending on the request
        jsonData = roomSearchDao.getRoomsFromQuery(arguments); // Method to fetch hotels by chain ID

        // Respond with the json object
        PrintWriter out = response.getWriter();
        out.print(jsonData);
        out.flush();
    }
}
