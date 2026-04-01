package examples;

import java.util.ArrayList;

public class UserService {
    private ArrayList<SystemUser> users = new ArrayList<>();

    public void addUser(SystemUser user) {
        if (!user.isValidUser()) {
            System.out.println("Invalid user data.");
            return;
        }

        if (findByEmail(user.getEmail()) != null) {
            System.out.println("Duplicate email. User not added.");
            return;
        }

        users.add(user);
        System.out.println("User added successfully.");
    }

    public SystemUser findByEmail(String email) {
        for (SystemUser user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void listUsers() {
        for (SystemUser user : users) {
            user.showSummary();
        }
    }

    public int getTotalUsers() {
        return users.size();
    }
}