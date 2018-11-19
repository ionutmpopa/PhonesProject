package com.iopo;

public interface Phone {

    boolean addContacts(String indexPos, String firstName, String lastName, String phoneNumber);
    void listContacts();
    void removeContact(String name);
    void sendMessage(String phoneNumber, String messageContent);
    void listMessages(String phoneNumber);
    void call (String phoneNumber);
    void viewHistory();
}
