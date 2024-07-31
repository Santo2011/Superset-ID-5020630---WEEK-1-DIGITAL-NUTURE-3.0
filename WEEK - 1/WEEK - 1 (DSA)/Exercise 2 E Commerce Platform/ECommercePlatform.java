package com.mycompany.ecommerceplatform;

import java.util.Arrays;
import java.util.Scanner;

// Define the Product class
class Product implements Comparable<Product> {
    private String productId;
    private String productName;
    private String category;

    // Constructor
    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category + "]";
    }

    // Implement compareTo for sorting
    @Override
    public int compareTo(Product other) {
        return this.productId.compareTo(other.productId);
    }
}

// Define the ECommercePlatform class with search functionality
public class ECommercePlatform {

    // Linear Search
    public static Product linearSearch(Product[] products, String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(productId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of products
        Product[] products = {
            new Product("101", "Laptop", "Electronics"),
            new Product("102", "Smartphone", "Electronics"),
            new Product("103", "Tablet", "Electronics"),
            new Product("104", "Headphones", "Accessories"),
            new Product("105", "Charger", "Accessories")
        };

        // Sort the array for binary search
        Arrays.sort(products);

        System.out.println("E-commerce Platform Search Function");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Product ID to search: ");
        String productId = scanner.nextLine();

        Product result = null;
        long startTime, endTime;

        switch (choice) {
            case 1:
                startTime = System.nanoTime();
                result = linearSearch(products, productId);
                endTime = System.nanoTime();
                System.out.println("Linear Search Time: " + (endTime - startTime) + " ns");
                break;

            case 2:
                startTime = System.nanoTime();
                result = binarySearch(products, productId);
                endTime = System.nanoTime();
                System.out.println("Binary Search Time: " + (endTime - startTime) + " ns");
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (result != null) {
            System.out.println("Product found: " + result);
        } else {
            System.out.println("Product not found.");
        }

        scanner.close();
    }
}
