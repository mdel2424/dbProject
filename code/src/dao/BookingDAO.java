package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Booking;
import util.DBConnection;

public class BookingDAO{

    // Method to retrieve all bookings
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM Booking";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBookingId(rs.getInt("BookingId"));
                booking.setStatus(rs.getString("Status"));
                booking.setStartDate(rs.getDate("StartDate"));
                booking.setEndDate(rs.getDate("EndDate"));
                booking.setRoomId(rs.getInt("RoomId"));
                booking.setClientId(rs.getInt("ClientId"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    // Method to insert a new booking
    public boolean insertBooking(Booking booking) {
        String sql = "INSERT INTO Booking (Status, StartDate, EndDate, RoomId, ClientId) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, booking.getStatus());
            pstmt.setDate(2, new java.sql.Date(booking.getStartDate().getTime()));
            pstmt.setDate(3, new java.sql.Date(booking.getEndDate().getTime()));
            pstmt.setInt(4, booking.getRoomId());
            pstmt.setInt(5, booking.getClientId());
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to update an existing booking
    public boolean updateBooking(Booking booking) {
        String sql = "UPDATE Booking SET Status = ?, StartDate = ?, EndDate = ?, RoomId = ?, ClientId = ? WHERE BookingId = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, booking.getStatus());
            pstmt.setDate(2, new java.sql.Date(booking.getStartDate().getTime()));
            pstmt.setDate(3, new java.sql.Date(booking.getEndDate().getTime()));
            pstmt.setInt(4, booking.getRoomId());
            pstmt.setInt(5, booking.getClientId());
            pstmt.setInt(6, booking.getBookingId());
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete a booking
    public boolean deleteBooking(int bookingId) {
        String sql = "DELETE FROM Booking WHERE BookingId = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, bookingId);
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Booking getBooking(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBooking'");
    }
}
