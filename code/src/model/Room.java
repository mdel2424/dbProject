package model;

import java.sql.Array;

public class Room {
    private int roomId;
    private Array damages;
    private String view;
    private int price;
    private String capacity;
    private int roomNumber;
    private boolean extendable;
    private Array amenities;
    private int hotelId;

    public Room(int roomId, Array damages, String view, int price, String capacity, int roomNumber, boolean extendable,Array amenities,
                 int hotelId) {
        this.roomId = roomId;
        this.damages = damages;
        this.view = view;
        this.price = price;
        this.roomNumber = roomNumber;
        this.extendable = extendable;
        this.capacity = capacity;
        this.amenities = amenities;
        this.hotelId = hotelId;
    }

    public Room() {
        //TODO Auto-generated constructor stub
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setDamages(Array damages) {
        this.damages = damages;
    }

    public void setView(String view) {
        this.view = view;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public void setExtendable(boolean extendable) {
        this.extendable = extendable;
    }

    public void setAmenities(Array array) {
        this.amenities = array;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoomId() {
        return roomId;
    }

    public Array getDamages() {
        return damages;
    }

    public String getView() {
        return view;
    }

    public double getPrice() {
        return price;
    }

    public String getCapacity() {
        return capacity;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public boolean isExtendable() {
        return extendable;
    }


    public Array getAmenities() {
        return amenities;
    }

    public int getHotelId() {
        return hotelId;
    }

    // Constructors, getters, and setters
}
