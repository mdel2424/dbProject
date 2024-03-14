package model;

public class HotelChain {
    private int chainId;
    private int nHotels;
    private String HQAddress;
    private String contactEmails;
    private String phoneNumber;
    private String hotelChainName;

    public HotelChain(int chainId, int nHotels, String HQAddress, String contactEmails, String phoneNumber, String hotelChainName) {
        this.chainId = chainId;
        this.nHotels = nHotels;
        this.HQAddress = HQAddress;
        this.contactEmails = contactEmails;
        this.phoneNumber = phoneNumber;
        this.hotelChainName = hotelChainName;
    }

    public HotelChain() {
        //TODO Auto-generated constructor stub
    }

    public int getChainId() {
        return chainId;
    }

    public int getNHotels() {
        return nHotels;
    }

    public String getHQAddress() {
        return HQAddress;
    }

    public String getContactEmails() {
        return contactEmails;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getHotelChainName() {
        return hotelChainName;
    }

    public void setChainId(int chainId) {
        this.chainId = chainId;
    }

    public void setNHotels(int nHotels) {
        this.nHotels = nHotels;
    }

    public void setHQAddress(String HQAddress) {
        this.HQAddress = HQAddress;
    }

    public void setContactEmails(String contactEmails) {
        this.contactEmails = contactEmails;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setHotelChainName(String hotelChainName) {
        this.hotelChainName = hotelChainName;
    }

    // Constructors, getters, and setters
}
