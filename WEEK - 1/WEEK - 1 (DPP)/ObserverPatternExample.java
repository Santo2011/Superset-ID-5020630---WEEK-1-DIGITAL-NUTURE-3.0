package com.mycompany.observerpatternexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Step 2: Define Subject Interface
interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// Step 3: Implement Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers;
    private int price;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    public void setPrice(int price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}

// Step 4: Define Observer Interface
interface Observer {
    void update(int price);
}

// Step 5: Implement Concrete Observers
class MobileApp implements Observer {
    @Override
    public void update(int price) {
        System.out.println("Mobile App: Stock price updated to " + price);
    }
}

class WebApp implements Observer {
    @Override
    public void update(int price) {
        System.out.println("Web App: Stock price updated to " + price);
    }
}

// Step 6: Test the Observer Implementation
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a new stock price (or -1 to exit): ");
            int newPrice = scanner.nextInt();
            if (newPrice == -1) {
                break;
            }
            stockMarket.setPrice(newPrice);

            System.out.println("Do you want to add or remove an observer? (1 to add, 2 to remove, 0 to continue): ");
            int action = scanner.nextInt();
            if (action == 1) {
                System.out.println("Enter 1 to add MobileApp observer, 2 to add WebApp observer: ");
                int observerType = scanner.nextInt();
                if (observerType == 1) {
                    stockMarket.registerObserver(new MobileApp());
                } else if (observerType == 2) {
                    stockMarket.registerObserver(new WebApp());
                }
            } else if (action == 2) {
                System.out.println("Enter 1 to remove MobileApp observer, 2 to remove WebApp observer: ");
                int observerType = scanner.nextInt();
                if (observerType == 1) {
                    stockMarket.removeObserver(mobileApp);
                } else if (observerType == 2) {
                    stockMarket.removeObserver(webApp);
                }
            }
        }
        scanner.close();
    }
}
