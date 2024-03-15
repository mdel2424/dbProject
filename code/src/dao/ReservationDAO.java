package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.Reservation;
import util.DBConnection;

public class ReservationDAO implements GenericDAO{

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM Reservation";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(rs.getInt("ReservationID"));
                reservation.setCheckInDate(rs.getDate("CheckInDate"));
                reservation.setCheckOutDate(rs.getDate("CheckOutDate"));
                reservation.setRoomId(rs.getInt("RoomID"));
                reservation.setClientId(rs.getInt("ClientID"));
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public Reservation getReservationById(int reservationId) {
        Reservation reservation = null;
        String sql = "SELECT * FROM Reservation WHERE ReservationID = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, reservationId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                reservation = new Reservation();
                reservation.setReservationId(rs.getInt("ReservationID"));
                reservation.setCheckInDate(rs.getDate("CheckInDate"));
                reservation.setCheckOutDate(rs.getDate("CheckOutDate"));
                reservation.setRoomId(rs.getInt("RoomID"));
                reservation.setClientId(rs.getInt("ClientID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservation;
    }

    public boolean addReservation(Reservation reservation) {
        boolean status = false;
        String sql = "INSERT INTO Reservation (CheckInDate, CheckOutDate, RoomID, ClientID) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDate(1, new java.sql.Date(reservation.getCheckInDate().getTime()));
            pstmt.setDate(2, new java.sql.Date(reservation.getCheckOutDate().getTime()));
            pstmt.setInt(3, reservation.getRoomId());
            pstmt.setInt(4, reservation.getClientId());
            
            int rowsAffected = pstmt.executeUpdate();
            status = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public Reservation getReservation(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReservation'");
    }

    public void deleteReservation(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteReservation'");
    }

    @Override
    public String getAllJson() {
        List<Reservation> reservations = getAllReservations();
        Gson gson = new Gson();
        return gson.toJson(reservations);
    }

    // Similarly, implement updateReservation and deleteReservation methods
}
