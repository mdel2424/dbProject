package servlet;

import dao.RoomDAO;
import model.Room;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
    private RoomDAO roomDAO;

    public void init() {
        roomDAO = new RoomDAO(); // Ensure RoomDAO has a constructor or provide it using dependency injection
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                    insertRoom(request, response);
                    break;
                case "delete":
                    deleteRoom(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateRoom(request, response);
                    break;
                default:
                    listRooms(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void listRooms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> listRoom = roomDAO.getAllRooms();
        request.setAttribute("listRoom", listRoom);
        RequestDispatcher dispatcher = request.getRequestDispatcher("room-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("room-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Room existingRoom = roomDAO.getRoom(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("room-form.jsp");
        request.setAttribute("room", existingRoom);
        dispatcher.forward(request, response);
    }

    private void insertRoom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Implementation depends on the parameters and the Room model
    }

    private void updateRoom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Implementation depends on the parameters and the Room model
    }

    private void deleteRoom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        roomDAO.deleteRoom(id);
        response.sendRedirect("list");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
