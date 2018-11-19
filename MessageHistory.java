package com.iopo;

import java.util.ArrayList;

public class MessageHistory {

    private String phoneNumber;
    private String messageContent;
    private static ArrayList<MessageHistory> messageHistory = new ArrayList<MessageHistory>();

    public MessageHistory(String phoneNumber, String messageContent) {

        this.phoneNumber = phoneNumber;
        this.messageContent = messageContent;
    }

    public boolean addMessages(String phoneNumber, String messageContent) {

        MessageHistory myHistory = new MessageHistory(phoneNumber, messageContent);

        if (this.getMessageContent() != null) {
            return messageHistory.add(myHistory);
        }
        return false;
    }

    public static String getMessages(String phoneNumber) {
        for (int i = 0; i < messageHistory.size(); i++) {
            if (messageHistory.get(i).getPhoneNumber().equals(phoneNumber)) {
                return messageHistory.get(i).getPhoneNumber() + " -> " + messageHistory.get(i).getMessageContent();
            }
        }
        return "No messages for " + phoneNumber;

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessageContent() {
        return messageContent;
    }
}
