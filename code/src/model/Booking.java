package model;

import java.sql.Date;

public class Booking {
    private int bookingId;
    private String status;
    private Date startDate;
    private Date endDate;
    private int roomId;
    private int clientId;

    private String clientName;

    private int roomNumber;

    public Booking(int bookingId, String status, Date startDate, Date endDate, int roomId, int clientId, String clientName, int roomNumber) {
        this.bookingId = bookingId;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomId = roomId;
        this.clientId = clientId;
        this.clientName = clientName;
        this.roomNumber = roomNumber;
    }

    public Booking() {
        //TODO Auto-generated constructor stub
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getStatus() {
        return status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    


    // Constructors, getters, and setters
}
