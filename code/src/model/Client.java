package model;

import java.sql.Date;

public class Client {
    private int ssn;
    private String fullName;
    private String address;
    private Date registrationDate;

    public Client(int ssn, String fullName, String address, Date registrationDate) {
        this.ssn = ssn;
        this.fullName = fullName;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    public Client() {
        //TODO Auto-generated constructor stub
    }

    public Client(String ssn2, String fullName2, String address2) {
        //TODO Auto-generated constructor stub
    }

    public int getSsn() {
        return ssn;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    public void setId(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    // Constructors, getters, and setters
}
