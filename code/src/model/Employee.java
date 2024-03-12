package model;

public class Employee {
    private String ssn;
    private String fullName;
    private String address;
    private String role;
    private int hotelId;

    public Employee(String ssn, String fullName, String address, String role, int hotelId) {
        this.ssn = ssn;
        this.fullName = fullName;
        this.address = address;
        this.role = role;
        this.hotelId = hotelId;
    }

    public Employee() {
        //TODO Auto-generated constructor stub
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    public int getHotelId() {
        return hotelId;
    }

    // Constructors, getters, and setters
}
