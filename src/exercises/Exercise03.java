package exercises;

import java.util.ArrayList;

class StockItem {
    private final int id;
    private final String name;
    private final int quantity;

    public StockItem(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isValidItem() {
        return name != null
            && name.trim().length() >= 3
            && quantity >= 0;
    }

    public void showItemSummary() {
        System.out.printf("Id: %d | Name: %s | Quantity: %d%n", id, name, quantity);
    }
}

class StockService {
    private final ArrayList<StockItem> items = new ArrayList<>();

    public void addItem(StockItem item) {
        if (item == null) {
            System.out.println("Item cannot be null.");
            return;
        }

        if (!item.isValidItem()) {
            System.out.println("Invalid item data.");
            return;
        }

        if (item.getId() < 1) {
            System.out.println("id must be greater than zero.");
            return;
        }

        if (findById(item.getId()) != null) {
            System.out.println("id duplicate. Item not added.");
            return;
        }

        items.add(item);
        System.out.println("Item added successfully.");
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("No items registered.");
            return;
        }

        for (StockItem item : items) {
            item.showItemSummary();
        }
    }

    public StockItem findById(int id) {
        for (StockItem item : items) {
            if (id == item.getId()) {
                return item;
            }
        }
        return null;
    }
}

public class Exercise03 {
    public static void main(String[] args) {
        StockService stockService = new StockService();

        stockService.addItem(new StockItem(1, "iPhone 12", 2));
        stockService.addItem(new StockItem(2, "iPhone 13", 0));
        stockService.addItem(new StockItem(3, "TV", 5));
        stockService.addItem(new StockItem(4, "Notebook", -1));
        stockService.addItem(new StockItem(1, "iPhone 14", 4));

        System.out.println("\n---- Final stock list ----");
        stockService.listItems();
    }
}