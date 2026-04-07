package challenge;

public class CustomerRecord {
    private int id;
    private String fullName;
    private String email;
    private boolean active;

    public CustomerRecord(int id, String fullName, String email, boolean active) {
        this.id = id;
        this.fullName = fullName == null ? null : fullName.trim();
        this.email = email == null ? null : email.trim();
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isValidCustomer() {
        return fullName.length() >= 3
            && email.contains("@");
    }

    public void showCustomerSummary() {
        System.out.printf("Id: %d | Full name: %s | Email: %s | Active: %b", id, fullName, email, active);
    }
}
