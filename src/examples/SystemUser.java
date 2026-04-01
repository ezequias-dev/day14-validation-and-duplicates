package examples;

public class SystemUser {
    private int id;
    private String fullName;
    private String email;
    private String role;
    private boolean active;

    public SystemUser(int id, String fullName, String email, String role, boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isValidUser() {
        return fullName.trim().length() >= 3
                && email.contains("@")
                && role.trim().length() >= 4;
    }

    public void showSummary() {
        System.out.println(
                "Id: " + id +
                " | Name: " + fullName +
                " | Email: " + email +
                " | Role: " + role +
                " | Active: " + active
        );
    }
}