package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import model.Booking;
import util.DBConnection;

public class BookingSearchDAO {

    public String getBookingsFromQuery(Map<String, String[]> arguments) {
        StringBuilder sql = new StringBuilder(
            "SELECT B.*, C.fullname AS clientName, R.roomnumber AS roomNumber FROM Booking B " +
            "INNER JOIN Client C ON B.clientId = C.ssn " +
            "INNER JOIN Room R ON B.roomId = R.roomid"
        );
        
        if (!arguments.isEmpty()) {
            sql.append(" WHERE ");
            boolean first = true;
        
            // Assuming 'name' is a criteria to filter clients
            if (arguments.containsKey("bookingName")) {
                String name = arguments.get("bookingName")[0]; // Assuming arguments is a Map<String, String[]>
                if (!first) sql.append(" AND ");
                sql.append("C.fullname = '").append(name.replace("'", "''")).append("'");
                first = false;
            }
        }
        List<Booking> bookings = new ArrayList<>();

        System.out.println(sql.toString());
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString());
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBookingId(rs.getInt("bookingId"));
                booking.setStatus(rs.getString("Status"));
                booking.setStartDate(rs.getDate("startDate"));
                booking.setEndDate(rs.getDate("endDate"));
                booking.setRoomId(rs.getInt("roomId"));
                booking.setClientId(rs.getInt("clientId"));
                booking.setClientName(rs.getString("clientName"));
                booking.setRoomNumber(rs.getInt("roomNumber"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(bookings);
    }
}
