package com.mycompany.taskmanagementsystem;

import java.util.Scanner;

public class TaskManagementSystem {

    // Define the Task class as an inner class
    public static class Task {
        private String taskId;
        private String taskName;
        private String status;
        private Task next;

        // Constructor
        public Task(String taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
            this.next = null;
        }

        // Getters and setters
        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Task getNext() {
            return next;
        }

        public void setNext(Task next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Task [taskId=" + taskId + ", taskName=" + taskName + ", status=" + status + "]";
        }
    }

    private Task head;

    // Constructor
    public TaskManagementSystem() {
        head = null;
    }

    // Method to add a task
    public void addTask(Task task) {
        if (head == null) {
            head = task;
        } else {
            Task current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(task);
        }
    }

    // Method to search a task by taskId
    public Task searchTask(String taskId) {
        Task current = head;
        while (current != null) {
            if (current.getTaskId().equals(taskId)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // Method to traverse and print all tasks
    public void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    // Method to delete a task by taskId
    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("Task list is empty. Cannot delete.");
            return;
        }

        if (head.getTaskId().equals(taskId)) {
            head = head.getNext();
            return;
        }

        Task current = head;
        Task previous = null;

        while (current != null && !current.getTaskId().equals(taskId)) {
            previous = current;
            current = current.getNext();
        }

        if (current != null) {
            previous.setNext(current.getNext());
        } else {
            System.out.println("Task not found. Cannot delete.");
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter taskId: ");
                    String taskId = scanner.nextLine();
                    System.out.print("Enter taskName: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();
                    Task task = new Task(taskId, taskName, status);
                    tms.addTask(task);
                    break;

                case 2:
                    System.out.print("Enter taskId to search: ");
                    taskId = scanner.nextLine();
                    Task foundTask = tms.searchTask(taskId);
                    if (foundTask != null) {
                        System.out.println("Task found: " + foundTask);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 3:
                    tms.traverseTasks();
                    break;

                case 4:
                    System.out.print("Enter taskId to delete: ");
                    taskId = scanner.nextLine();
                    tms.deleteTask(taskId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
