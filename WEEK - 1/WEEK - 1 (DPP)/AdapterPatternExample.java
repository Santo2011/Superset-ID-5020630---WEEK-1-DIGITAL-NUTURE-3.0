package com.mycompany.adapterpatternexample;

// Step 2: Define Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Step 3: Implement Adaptee Classes
class PayPal {
    public void sendPayment(double amount) {
        System.out.println("Processing payment of " + amount + " through PayPal.");
    }
}

class Stripe {
    public void makePayment(double amount) {
        System.out.println("Processing payment of " + amount + " through Stripe.");
    }
}

// Step 4: Implement the Adapter Class
class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

// Step 5: Test the Adapter Implementation
public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        paypalProcessor.processPayment(100.00);

        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        stripeProcessor.processPayment(200.00);
    }
}
