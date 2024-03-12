package model;

import java.sql.Date;

public class Reservation {
    private int reservationId;
    private Date checkInDate;
    private Date checkOutDate;
    private int roomId;
    private int clientId;

    public Reservation(int reservationId, Date checkInDate, Date checkOutDate, int roomId, int clientId) {
        this.reservationId = reservationId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomId = roomId;
        this.clientId = clientId;
    }

    public Reservation() {
        //TODO Auto-generated constructor stub
    }

    public int getReservationId() {
        return reservationId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    // Constructors, getters, and setters
}
