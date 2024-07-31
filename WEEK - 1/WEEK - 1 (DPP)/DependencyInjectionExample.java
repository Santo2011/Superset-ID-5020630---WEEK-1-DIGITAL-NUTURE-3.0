package com.mycompany.dependencyinjectionexample;

import java.util.Scanner;

// Step 2: Define Repository Interface
interface CustomerRepository {
    Customer findCustomerById(String id);
}

// Step 3: Implement Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        // In a real application, this would query a database
        return new Customer(id, "Kumar jain");
    }
}

// Step 4: Define Service Class
class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(String id) {
        return customerRepository.findCustomerById(id);
    }
}

// Step 5: Define Customer Class
class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{id='" + id + "', name='" + name + "'}";
    }
}

// Step 6: Test the Dependency Injection Implementation
public class DependencyInjectionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create repository and service instances
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        while (true) {
            System.out.println("Enter customer ID to retrieve (or type 'exit' to quit):");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            Customer customer = customerService.getCustomer(input);
            System.out.println(customer);
        }

        scanner.close();
    }
}
