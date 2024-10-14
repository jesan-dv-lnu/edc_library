package se.lnu.jesan.library.users;

public class User {
    private String name;
    private String userId;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // A generic method to display user details
    public void displayInfo() {
        System.out.println("User Name: " + name);
        System.out.println("User ID: " + userId);
    }
}

