package dao;

import model.Room;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    public Room getRoomById(int roomId) {
        Room room = null;
        String sql = "SELECT * FROM Room WHERE RoomId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, roomId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                room = new Room();
                room.setRoomId(rs.getInt("RoomId"));
                room.setDamages(rs.getString("Damages"));
                room.setView(rs.getString("View"));
                room.setPrice(rs.getDouble("Price"));
                room.setCapacity(rs.getString("Capacity"));
                room.setAircondition(rs.getBoolean("Aircondition"));
                room.setExtendable(rs.getBoolean("Extendable"));
                room.setHotelId(rs.getInt("HotelId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM Room";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("RoomId"));
                room.setDamages(rs.getString("Damages"));
                room.setView(rs.getString("View"));
                room.setPrice(rs.getDouble("Price"));
                room.setCapacity(rs.getString("Capacity"));
                room.setAircondition(rs.getBoolean("Aircondition"));
                room.setExtendable(rs.getBoolean("Extendable"));
                room.setHotelId(rs.getInt("HotelId"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public Room getRoom(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRoom'");
    }

    public void deleteRoom(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRoom'");
    }

    // Methods to insert, update, and delete rooms will follow a similar pattern.
}