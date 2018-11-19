package com.iopo;

public class Contact {

    private String indexPos;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String indexPos, String firstName, String lastName, String phoneNumber) {
        this.indexPos = indexPos;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getIndexPos() {
        return indexPos;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return firstName + " " + lastName;
    }
}