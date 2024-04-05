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

import model.Hotel;
import model.Room;
import util.DBConnection;

public class RoomSearchDAO {

    public String getRoomsFromQuery(Map<String, String[]> arguments) {
        List<Room> rooms = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM Room as R INNER JOIN Hotel as H ON R.HotelId = H.HotelId");

        if (!arguments.isEmpty()) {
            sql.append(" WHERE ");
            boolean first = true;
    
            // Additional parameters handling
            if (arguments.containsKey("checkInDate") && arguments.containsKey("checkOutDate")) {
                String checkInDate = arguments.get("checkInDate")[0];
                String checkOutDate = arguments.get("checkOutDate")[0];
                if (!first) sql.append(" AND ");
                sql.append("R.RoomId NOT IN (SELECT RoomId FROM Booking WHERE (startdate <= '")
                    .append(checkOutDate)
                    .append("' AND enddate >= '")
                    .append(checkInDate)
                    .append("'))");

                sql.append(" AND R.RoomId NOT IN (SELECT RoomId FROM Reservation WHERE (checkindate <= '")
                    .append(checkOutDate)
                    .append("' AND checkoutdate >= '")
                    .append(checkInDate)
                    .append("'))");

                first = false;
            }

            if (arguments.containsKey("roomCapacity")) {
                if (!first) sql.append(" AND ");
                sql.append("R.capacity = ").append(arguments.get("roomCapacity")[0]);
                first = false;
            }
    
            // Handling hotelChain
            if (arguments.containsKey("hotelChain")) {
                if (!first) sql.append(" AND ");
                sql.append("H.chainid = ").append(arguments.get("hotelChain")[0]);
                first = false;
            }
    
            // Handling hotelCategory
            if (arguments.containsKey("hotelCategory")) {
                if (!first) sql.append(" AND ");
                sql.append("H.starrating = '").append(arguments.get("hotelCategory")[0]+"'");
                first = false;
            }

            //Trying to get Location from DB
            if (arguments.containsKey("location")) {
                if (!first) sql.append(" AND ");
                sql.append("H.\"Address\" LIKE '%").append(arguments.get("location")[0]+"%'");
                first = false;
            }
            

            if (arguments.containsKey("hotelCapacityMin")) {
                if (!first) sql.append(" AND ");
                sql.append("H.nrooms >= ").append(arguments.get("hotelCapacityMin")[0]);
                first = false;
            }
            if (arguments.containsKey("hotelCapacityMax")) {
                if (!first) sql.append(" AND ");
                sql.append("H.nrooms <= ").append(arguments.get("hotelCapacityMax")[0]);
                first = false;
            }
            if (arguments.containsKey("roomPriceMin")) {
                if (!first) sql.append(" AND ");
                sql.append("R.price >= ").append(arguments.get("roomPriceMin")[0]);
                first = false;
            }
            if (arguments.containsKey("roomPriceMax")) {
                if (!first) sql.append(" AND ");
                sql.append("R.price <= ").append(arguments.get("roomPriceMax")[0]);
                first = false;
            }
        }
        System.out.println(sql.toString());
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("RoomId"));
                Array damagesArray = rs.getArray("Damages");
                String[] damages = (String[]) damagesArray.getArray();
                room.setDamages(Arrays.asList(damages));
                room.setView(rs.getString("View"));
                room.setPrice(rs.getInt("Price"));
                room.setCapacity(rs.getString("Capacity"));
                room.setRoomNumber(rs.getInt("RoomNumber"));
                room.setExtendable(rs.getBoolean("Extendable"));
                Array amenitiesArray = rs.getArray("Amenities");
                String[] amenities = (String[]) amenitiesArray.getArray();
                room.setAmenities(Arrays.asList(amenities));
                room.setHotelId(rs.getInt("HotelId"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(rooms);
    }
}
