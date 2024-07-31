package com.mycompany.customersorting;

import java.util.Arrays;
import java.util.Scanner;

// Define the Order class
class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    // Constructor
    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customerName=" + customerName + ", totalPrice=" + totalPrice + "]";
    }
}

// Define the CustomerSorting class with sorting functionality
public class CustomerSorting {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of orders
        Order[] orders = {
            new Order("001", "Alice", 250.0),
            new Order("002", "Bob", 150.0),
            new Order("003", "Charlie", 300.0),
            new Order("004", "David", 200.0),
            new Order("005", "Eve", 100.0)
        };

        System.out.println("E-commerce Platform Order Sorting");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        
        long startTime, endTime;

        switch (choice) {
            case 1:
                startTime = System.nanoTime();
                bubbleSort(orders);
                endTime = System.nanoTime();
                System.out.println("Bubble Sort Time: " + (endTime - startTime) + " ns");
                break;

            case 2:
                startTime = System.nanoTime();
                quickSort(orders, 0, orders.length - 1);
                endTime = System.nanoTime();
                System.out.println("Quick Sort Time: " + (endTime - startTime) + " ns");
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Sorted Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }

        scanner.close();
    }
}
