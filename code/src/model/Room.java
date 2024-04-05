package model;

import java.util.List;

public class Room {
    private int roomId;
    private String location;
    
    private List<String> damages;
    private String view;
    private int price;
    private String capacity;
    private int roomNumber;
    private boolean extendable;
    private List<String> amenities;
    private int hotelId;
    
    public Room(int roomId, String location, List<String> damages, String view, int price, String capacity, int roomNumber, boolean extendable, List<String> amenities,
    int hotelId) {
        this.location = location;
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

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setDamages(List<String> damages) {
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

    public void setAmenities(List<String> array) {
        this.amenities = array;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoomId() {
        return roomId;
    }

    public List<String> getDamages() {
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

    public List<String> getAmenities() {
        return amenities;
    }

    public int getHotelId() {
        return hotelId;
    }

    // Constructors, getters, and setters
}
