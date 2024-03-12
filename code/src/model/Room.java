package model;

public class Room {
    private int roomId;
    private String damages;
    private String view;
    private double price;
    private String capacity;
    private boolean aircondition;
    private boolean extendable;
    private int hotelId;

    public Room(int roomId, String damages, String view, double price, String capacity, boolean aircondition,
            boolean extendable, int hotelId) {
        this.roomId = roomId;
        this.damages = damages;
        this.view = view;
        this.price = price;
        this.capacity = capacity;
        this.aircondition = aircondition;
        this.extendable = extendable;
        this.hotelId = hotelId;
    }

    public Room() {
        //TODO Auto-generated constructor stub
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setDamages(String damages) {
        this.damages = damages;
    }

    public void setView(String view) {
        this.view = view;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setAircondition(boolean aircondition) {
        this.aircondition = aircondition;
    }

    public void setExtendable(boolean extendable) {
        this.extendable = extendable;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getDamages() {
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

    public boolean isAircondition() {
        return aircondition;
    }

    public boolean isExtendable() {
        return extendable;
    }

    public int getHotelId() {
        return hotelId;
    }

    // Constructors, getters, and setters
}
