package exercises;

import java.util.ArrayList;

class EmployeeRecord {
    private final String fullName;
    private final String document;
    private final double salary;

    public EmployeeRecord(String fullName, String document, double salary) {
        this.fullName = fullName;
        this.document = document;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDocument() {
        return document;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isValidEmployee() {
        return fullName != null
            && fullName.trim().length() >= 3
            && document != null
            && document.trim().length() >= 5
            && salary > 0;
    }

    public void showEmployeeSummary() {
        System.out.printf("Full Name: %s | Document: %s | Salary: $%.2f%n", getFullName(), getDocument(), getSalary());
    }
}

class EmployeeService {
    private final ArrayList<EmployeeRecord> employees = new ArrayList<>();

    public void addEmployee(EmployeeRecord employee) {
        if (employee == null) {
            System.out.println("Employee cannot be null.");
            return;
        }

        if (!employee.isValidEmployee()) {
            System.out.println("Invalid employee data.");
            return;
        }

        if (findByDocument(employee.getDocument()) != null) {
            System.out.println("Duplicate document. Employee not added.");
            return;
        }

        employees.add(employee);
        System.out.println("Employee added successfully");
    }

    public EmployeeRecord findByDocument(String document) {
        if (document == null) {
            return null;
        }

        for (EmployeeRecord employee : employees) {
            if (document.equals(employee.getDocument())) {
                return employee;
            }
        }

        return null;
    }

    public void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No registered employees.");
            return;
        }

        for (EmployeeRecord employee : employees) {
            employee.showEmployeeSummary();
        }
    }
}

public class Exercise04 {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();

        employeeService.addEmployee(new EmployeeRecord("Ezequias Souza", "367829", 13569.00)); // válido
        employeeService.addEmployee(new EmployeeRecord("Paulo Almeida", "094334", 11400.00));   // válido
        employeeService.addEmployee(new EmployeeRecord("Ma", "55555", 3000.00));                 // nome inválido
        employeeService.addEmployee(new EmployeeRecord("Marli Santos", "7485", 9500.00));        // documento inválido
        employeeService.addEmployee(new EmployeeRecord("James Salady", "77777", 0));             // salário inválido
        employeeService.addEmployee(new EmployeeRecord("Ana Costa", "094334", 8780.00));         // duplicado

        System.out.println("\n---- FINAL EMPLOYEES LIST ----");
        employeeService.listEmployees();
    }
}