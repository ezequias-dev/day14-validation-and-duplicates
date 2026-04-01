package exercises;

import java.util.ArrayList;

class ProductRecord {
    private final int id;
    private final String name;
    private final double price;

    public ProductRecord (int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isValidProduct() {
        return name != null && name.trim().length() >= 3 && price > 0;
    }

    public String toString() {
        return String.format("Id: %d | Name: %s | Price: $%.2f%n", getId(), getName(), getPrice());
    }
}

class ProductService {
    private final ArrayList<ProductRecord> products = new ArrayList<>();

    public boolean addProduct(ProductRecord product) {
        if (product == null) {
            return false;
        }

        if (!product.isValidProduct()) {
            return false;
        }

        if (findById(product.getId()) != null) {
            return false;
        }

        products.add(product);
        return true;
    }

    public ProductRecord findById(int id) {
        for (ProductRecord product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products registered.");
            return;
        }

        for (ProductRecord product : products) {
            System.out.println(product);
        }
    }
}

public class Exercise01 {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        boolean firstProductAdded = productService.addProduct(new ProductRecord(1, "MacBook Neo", 799.90));
        boolean invalidProductAdded = productService.addProduct(new ProductRecord(2, "MacBook Air", 0));
        boolean duplicateProductAdded = productService.addProduct(new ProductRecord(1, "MacBook Pro", 1799.90));

        System.out.println("First product added: " + firstProductAdded);
        System.out.println("Invalid product added: " + invalidProductAdded);
        System.out.println("Duplicate product added: " + duplicateProductAdded);

        System.out.println();
        System.out.println("---- LIST PRODUCTS ----");
        productService.listProducts();
    }
}