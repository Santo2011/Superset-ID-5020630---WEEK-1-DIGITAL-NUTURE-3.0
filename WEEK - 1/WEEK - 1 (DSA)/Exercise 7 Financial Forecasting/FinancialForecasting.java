package com.mycompany.financialforecasting;

import java.util.Scanner;

public class FinancialForecasting {

    // Method to calculate future value recursively
    public static double calculateFutureValue(double principal, double growthRate, int years) {
        // Base case: if years is 0, return the principal
        if (years == 0) {
            return principal;
        }
        // Recursive case: calculate future value based on growth rate
        return calculateFutureValue(principal * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Financial Forecasting Tool");
        System.out.print("Enter initial principal amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter annual growth rate (as a decimal, e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();
        System.out.print("Enter number of years for forecasting: ");
        int years = scanner.nextInt();
        
        double futureValue = calculateFutureValue(principal, growthRate, years);
        System.out.printf("Future value after %d years: %.2f%n", years, futureValue);

        scanner.close();
    }
}

