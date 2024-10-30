package programmer.zaman.now.application;

import programmer.zaman.now.error.DatabaseError;

public class DatabaseApp {
    public static void main(String[] args) {
        connectToDatabase("Ali", "12345678");
    }

    private static void connectToDatabase(String username, String password) {
        if(username == null || password == null) {
            throw new DatabaseError("Cannot connect to the database");
        } else {
            System.out.println("Connected to the database");
        }
    }
}
