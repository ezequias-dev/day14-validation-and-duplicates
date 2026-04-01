package review;

import java.util.ArrayList;

class ProductRecord {
    private final int id;
    private final String name;
    private final double price;

    public ProductRecord(int id, String name, double price) {
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

    @Override
    public String toString() {
        return String.format("Id: %d | Name: %s | Price: $%.2f", getId(), getName(), getPrice());
    }
}

class ProductService {
    private final ArrayList<ProductRecord> products = new ArrayList<>();

    public void addProduct(ProductRecord product) {
        if (product == null) {
            System.out.println("Cannot add null product.");
            return;
        }

        if (findProductById(product.getId()) != null) {
            System.out.println("A product with this id already exists.");
            return;
        }

        products.add(product);
    }

    public ProductRecord findProductById(int id) {
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

public class Day13QuickReview {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        productService.addProduct(new ProductRecord(1, "MacBook Neo", 599.90));
        productService.addProduct(new ProductRecord(2, "MacBook Air", 1099.90));
        productService.addProduct(new ProductRecord(3, "MacBook Pro", 1499.90));

        System.out.println("---- PRODUCT LIST ----");
        productService.listProducts();

        System.out.println("---- FIND BY ID 2 ----");
        showSearchProduct(productService.findProductById(2));

        System.out.println("---- FIND BY ID 4 ----");
        showSearchProduct(productService.findProductById(4));
    }

    private static void showSearchProduct(ProductRecord product) {
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found.");
        }
    }
}