package com.mycompany.singletonpatternexample;

public class SingletonPatternExample {

    public static void main(String[] args) {
        // Attempt to create multiple instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Verify that both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }

        // Test logging
        logger1.log("This is a test message.");
    }
}

// Logger class definition
class Logger {
    // Step 1: Create a private static instance of the class
    private static Logger instance;

    // Step 2: Make the constructor private to prevent instantiation
    private Logger() {
        // Private constructor
    }

    // Step 3: Provide a public static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
