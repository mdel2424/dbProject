package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import model.Booking;
import model.Room;
import util.DBConnection;

public class BookingSearchDAO {

    public String getRoomsFromQuery(Map<String, String[]> arguments) {
        StringBuilder sql = new StringBuilder(
            "SELECT B.*, R.* FROM Booking B " +
            "INNER JOIN Client C ON B.clientId = C.id " +
            "INNER JOIN Reservation R ON C.id = R.clientId"
        );
        
        if (!arguments.isEmpty()) {
            sql.append(" WHERE ");
            boolean first = true;
        
            // Assuming 'name' is a criteria to filter clients
            if (arguments.containsKey("name")) {
                String name = arguments.get("name")[0]; // Assuming arguments is a Map<String, String[]>
                if (!first) sql.append(" AND ");
                sql.append("C.name = '").append(name.replace("'", "''")).append("'");
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
                booking.setStartDate(rs.getDate("startDate"));
                booking.setEndDate(rs.getDate("endDate"));
                booking.setRoomId(rs.getInt("roomId"));
                booking.setClientId(rs.getInt("clientId"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(bookings);
    }
}
