package com.mycompany.strategypatternexample;

import java.util.Scanner;

// Step 2: Define Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Step 3: Implement Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// Step 4: Implement Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Step 5: Test the Strategy Implementation
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select payment method: 1 for Credit Card, 2 for PayPal, 0 to exit: ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            System.out.println("Enter amount to pay: ");
            double amount = scanner.nextDouble();

            switch (choice) {
                case 1:
                    context.setPaymentStrategy(new CreditCardPayment());
                    break;
                case 2:
                    context.setPaymentStrategy(new PayPalPayment());
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            context.pay(amount);
        }

        scanner.close();
    }
}
