package com.iopo;

public class Main {

    public static void main(String[] args) {

        //Phone phone1 = new Samsung(); // shouldn't compile
        Phone phone = new SamsungGalaxy6("Black", "Plastic", "12345678977");

        phone.addContacts("1", "George", "Stamate", "0756-454-333");
        phone.addContacts("2", "Claudiu", "Grenea", "0754-441-324");
        phone.listContacts();
        phone.removeContact("George Stamate");
        phone.removeContact("George Cretu");
        phone.listContacts();
        
        
        // send a message to the first contact from the previous listed
        // max number of characters - 100
         phone.sendMessage("0723-121-661", "Ce faci?");
         phone.sendMessage("0756-454-333", "Ai primit mesajul anterior?");

         phone.listMessages("0723-121-661");
         phone.listMessages("0756-454-333");

        // send a message to the second contact from the previous listed
         phone.call("0756-454-333");
         phone.call("0754-441-324");
         phone.call("0754-441-320");
        phone.viewHistory();
        
        System.out.println("###############################");
        Phone phone2 = new SamsungGalaxyNote9("White", "Plastic", "32343442634343");

        phone2.addContacts("1", "Stan", "SiBran", "112-211-133");
        phone2.addContacts("2", "Mihai", "Eminescu", "232-332-154");
        phone2.listContacts();

        phone2.sendMessage("112-211-133", "Ce faci?");
        phone2.sendMessage("0756-454-333", "Ai primit mesajul anterior?");
        phone2.sendMessage("232-332-154", "Ai primit mesajul anterior?");

        phone2.listMessages("0723-121-661");
        phone2.listMessages("0756-454-333");

        phone2.call("112-211-133");
        phone2.call("0756-454-333");
        phone2.call("232-332-154");
        phone2.viewHistory();

        System.out.println("###############################");

        Phone phone3 = new HuaweiP9Lite("Golden", "Aluminium", "132455554556");

        phone3.addContacts("1", "John", "Doe", "111-222-333");
        phone3.listContacts();
        phone3.sendMessage("111-222-333", "Cum te cheama?");
        phone3.listMessages("111-222-333");
        phone3.listMessages("111-000-333");
        phone3.call("111-222-333");
        phone3.viewHistory();

        System.out.println("###############################");
    }
}
