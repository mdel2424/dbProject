package model;

public class Hotel {
    private int hotelId;
    private String starRating;

    private int nRooms;

    private String address;

    private String contactEmails;

    private String phoneNumber;

    private int chainId;

    public Hotel(int hotelId, String starRating, int nRooms, String address, String contactEmails, String phoneNumber,
            int chainId) {
        this.hotelId = hotelId;
        this.starRating = starRating;
        this.nRooms = nRooms;
        this.address = address;
        this.contactEmails = contactEmails;
        this.phoneNumber = phoneNumber;
        this.chainId = chainId;
    }

    public Hotel() {
        //TODO Auto-generated constructor stub
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getStarRating() {
        return starRating;
    }

    public int getNRooms() {
        return nRooms;
    }

    public String getAddress() {
        return address;
    }

    public String getContactEmails() {
        return contactEmails;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getChainId() {
        return chainId;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public void setNRooms(int nRooms) {
        this.nRooms = nRooms;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setContactEmails(String contactEmails) {
        this.contactEmails = contactEmails;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setChainId(int chainId) {
        this.chainId = chainId;
    }

    // Constructors, getters, and setters
}
