package exercises;

import java.util.ArrayList;

class CustomerRecord {
    private String fullName;
    private String email;

    public CustomerRecord(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isValidCustomer() {
        return fullName != null
            && fullName.trim().length() >= 3
            && email != null
            && email.contains("@");
    }

    public void showCustomerSummary() {
        System.out.printf("Full name: %s | Email: %s%n", fullName, email);
    }
}

class CustomerService {
    private final ArrayList<CustomerRecord> customers = new ArrayList<>();

    public void addCustomer(CustomerRecord customer) {
        if (customer == null) {
            System.out.println("Customer cannot be null.");
            return;
        }

        if (!customer.isValidCustomer()) {
            System.out.println("Invalid customer data.");
            return;
        }

        if (findByEmail(customer.getEmail()) != null) {
            System.out.println("Duplicate email. Customer not added.");
            return;
        }

        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    public CustomerRecord findByEmail(String email) {
        if (email == null) {
            return null;
        }

        for (CustomerRecord customer : customers) {
            if (email.equals(customer.getEmail())) {
                return customer;
            }
        }
        return null;
    }

    public void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers registered.");
            return;
        }

        for (CustomerRecord customer : customers) {
            customer.showCustomerSummary();
        }
    }
}

public class Exercise02 {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();

        customerService.addCustomer(new CustomerRecord("Ezequias Souza", "ezequias@email.com"));
        customerService.addCustomer(new CustomerRecord("Marli Santos", "marli@email.com"));
        customerService.addCustomer(new CustomerRecord("Paulo Silva", "pauloemail.com"));
        customerService.addCustomer(new CustomerRecord("James Barros", "ezequias@email.com"));

        System.out.println("\nAccepted customers:");
        customerService.listCustomers();
    }
}