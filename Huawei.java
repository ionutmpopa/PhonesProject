package com.iopo;

import java.util.ArrayList;

public abstract class Huawei implements Phone {

    private double batteryLife;
    private String color;
    private String material;
    private final String imei;
    private ArrayList<Contact> contactListP20;
    private ArrayList<String> callHistoryP20;
    private double remainingBattery;


    public double getBatteryLife() {
        return batteryLife;
    }

    public Huawei(String color, String material, String imei, double batteryLife) {
        this.color = color;
        this.material = material;
        this.imei = imei;
        this.batteryLife = batteryLife;
        this.remainingBattery = batteryLife;
        this.contactListP20 = new ArrayList<Contact>();
        this.callHistoryP20 = new ArrayList<String>();

    }

    public double getRemainingBattery() {
        return remainingBattery;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public boolean addContacts(String indexPos, String firstName, String lastName, String phoneNumber) {

        Contact contact = new Contact(indexPos, firstName, lastName, phoneNumber);

        if (findContact(contact.toString()) >= 0) {
            System.out.println(contact.toString() + " is already in the list!");
            return false;
        }
        if (findContact(contact.getPhoneNumber()) >= 0) {
            System.out.println(contact.getPhoneNumber() + " is already in the list!");
            return false;
        }
        return contactListP20.add(contact);

    }

    public void listContacts() {
        System.out.println("You have " + contactListP20.size() + " contacts in your contact list");
        for (int i = 0; i < contactListP20.size(); i++) {
            System.out.println(contactListP20.get(i).getIndexPos() + ". " + contactListP20.get(i).toString() + " -> "
                    + contactListP20.get(i).getPhoneNumber());
        }
    }

    public void removeContact(String item) {
        int position = findContact(item);
        if (position >= 0) {
            removeContact(position);
            System.out.println("The position " + (position + 1) + " has been removed!");
        } else {
            System.out.println("This person is not in your contact list!");
        }
    }

    private void removeContact(int position) {
        contactListP20.remove(position);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < contactListP20.size(); i++) {
            Contact contact = contactListP20.get(i);

            if (contact.toString().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    private String findContactPhone(String phoneNumber) {
        for (int i = 0; i < contactListP20.size(); i++) {
            Contact contact = contactListP20.get(i);

            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact.toString();
            }
        }
        return null;
    }


    public void sendMessage(String phoneNumber, String messageContent) {
        String phoneList = findContactPhone(phoneNumber);
        MessageHistory messageHistory = new MessageHistory(phoneNumber, messageContent);


        if (messageContent.length() <= 500) {
            if (phoneList != null) {
                System.out.println("Sending the message to " + phoneList);
                this.remainingBattery = this.remainingBattery - 1;
                System.out.println("Remaining battery: " + this.getRemainingBattery());
            } else {
                System.out.println("Sending the message to " + phoneNumber);
                this.remainingBattery = this.remainingBattery - 1;
                System.out.println("Remaining battery: " + this.getRemainingBattery());
            }
        } else {
            System.out.println("The message is too long, it could not be sent!");
        }

        messageHistory.addMessages(phoneNumber, messageContent);
    }

    public void listMessages(String phoneNumber) {

        String phoneInList = findContactPhone(phoneNumber);
        if (phoneInList != null) {
            System.out.println("Message sent to: " + phoneInList + " -> " + MessageHistory.getMessages(phoneNumber));
        } else {
            System.out.println("Message sent to: " + "No name ->" + MessageHistory.getMessages(phoneNumber));
        }
    }


    public void call(String phoneNumber) {

        String phoneInList = findContactPhone(phoneNumber);

        if (phoneInList != null) {
            System.out.println("Calling..." + phoneInList);
            this.remainingBattery = this.remainingBattery - 2;
            System.out.println("Remaining battery: " + this.getRemainingBattery());
            callHistoryP20.add(phoneNumber);

        } else {
            System.out.println("Calling..." + phoneNumber);
            this.remainingBattery = this.remainingBattery - 2;
            System.out.println("Remaining battery: " + this.getRemainingBattery());
            callHistoryP20.add(phoneNumber);
        }
    }

    public void viewHistory() {

        System.out.println("The following numbers have been called:");
        for (String myModel : callHistoryP20) {

            String contactName = findContactPhone(myModel);

            if (contactName != null) {
                System.out.println(contactName + ": " + myModel);
            } else {
                System.out.println("No name: " + " " + myModel);
            }

        }

    }
}
