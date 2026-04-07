package challenge;

import java.util.ArrayList;

public class CustomerService {
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

        if (findById(customer.getId()) != null) {
            System.out.println("Duplicate id. Customer not added.");
        }

        if (findByEmail(customer.getEmail()) != null) {
            System.out.println("Duplicate email. Customer not added.");
        }

        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    public void listCustomers() {
        for (CustomerRecord customer : customers) {
            customer.showCustomerSummary();
        }
    }

    public CustomerRecord findById(int id) {
        if (id < 1) {
            System.out.println("id cannot be less than zero.");
            return null;
        }

        for (CustomerRecord customer : customers) {
            if (id == customer.getId()) {
                return customer;
            }
        }
        return null;
    }

    public CustomerRecord findByEmail(String email) {
        if (email == null) {
            System.out.println("Email cannot be null.");
            return null;
        }

        for (CustomerRecord customer : customers) {
            if (email.equals(customer.getEmail())) {
                return customer;
            }
        }
        return null;
    }

    public void changeActiveById(int id, boolean newActive) {
        CustomerRecord active = findById(id);

        active.setActive(newActive);
    }

    public void removeActiveById(int id) {
        for (int i = 0; i < customers.size(); i++) {
            customers.remove(id);
        }
    }


}