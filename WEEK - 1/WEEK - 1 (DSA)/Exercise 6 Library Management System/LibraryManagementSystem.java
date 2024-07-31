package com.mycompany.librarymanagementsystem;

import java.util.Arrays;
import java.util.Scanner;

public class LibraryManagementSystem {

    // Define the Book class as an inner class
    public static class Book {
        private String bookId;
        private String title;
        private String author;

        // Constructor
        public Book(String bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        // Getters and setters
        public String getBookId() {
            return bookId;
        }

        public void setBookId(String bookId) {
            this.bookId = bookId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + "]";
        }
    }

    private Book[] books;
    private int count;

    // Constructor
    public LibraryManagementSystem(int size) {
        books = new Book[size];
        count = 0;
    }

    // Method to add a book
    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Linear search to find a book by title
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Binary search to find a book by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title) {
        Arrays.sort(books, 0, count, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = title.compareToIgnoreCase(books[mid].getTitle());

            if (result == 0) {
                return books[mid];
            } else if (result < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem(100);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title (Linear Search)");
            System.out.println("3. Search Book by Title (Binary Search)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter bookId: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    Book book = new Book(bookId, title, author);
                    lms.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter title to search (Linear Search): ");
                    title = scanner.nextLine();
                    Book foundBookLinear = lms.linearSearchByTitle(title);
                    if (foundBookLinear != null) {
                        System.out.println("Book found: " + foundBookLinear);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter title to search (Binary Search): ");
                    title = scanner.nextLine();
                    Book foundBookBinary = lms.binarySearchByTitle(title);
                    if (foundBookBinary != null) {
                        System.out.println("Book found: " + foundBookBinary);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
