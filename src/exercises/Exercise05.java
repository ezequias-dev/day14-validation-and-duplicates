package exercises;

import java.util.ArrayList;

class OrderRecord {
    private final String code;
    private final double totalAmount;

    public OrderRecord(String code, double totalAmount) {
        this.code = code == null ? null : code.trim();
        this.totalAmount = totalAmount;
    }

    public String getCode() {
        return code;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isValidOrder() {
        return code != null
            && code.length() >= 3
            && totalAmount > 0;
    }

    public void showOrderSummary() {
        System.out.printf("Code: %s | Total amount: $%.2f%n", code, totalAmount);
    }
}

class OrderService {
    private final ArrayList<OrderRecord> orders = new ArrayList<>();

    public void addOrder(OrderRecord order) {
        if (order == null) {
            System.out.println("Order cannot be null.");
            return;
        }

        if (!order.isValidOrder()) {
            System.out.println("Invalid order data.");
            return;
        }

        if (findByCode(order.getCode()) != null) {
            System.out.println("Duplicate code. Order not added.");
            return;
        }

        orders.add(order);
        System.out.println("Order added successfully.");
    }

    public OrderRecord findByCode(String code) {
        if (code == null) {
            return null;
        }

        for (OrderRecord order : orders) {
            if (code.equals(order.getCode())) {
                return order;
            }
        }
        return null;
    }

    public void listOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders registered.");
            return;
        }

        for (OrderRecord order : orders) {
            order.showOrderSummary();
        }
    }
}

public class Exercise05 {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        orderService.addOrder(new OrderRecord("367", 13569.00));
        orderService.addOrder(new OrderRecord("9438", 11400.00));
        orderService.addOrder(new OrderRecord("37", 3000.00));
        orderService.addOrder(new OrderRecord("7485", 0));
        orderService.addOrder(new OrderRecord("9438", 12500.00));

        System.out.println("\n---- FINAL ORDERS LIST ----");
        orderService.listOrders();
    }
}