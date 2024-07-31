package com.mycompany.commandpatternexample;

import java.util.Scanner;

// Step 2: Define Command Interface
interface Command {
    void execute();
}

// Step 3: Implement Concrete Commands
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Step 4: Implement Invoker Class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Step 5: Implement Receiver Class
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Step 6: Test the Command Implementation
public class CommandPatternExample {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 to turn ON the light, 2 to turn OFF the light, 0 to exit: ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    remote.setCommand(lightOn);
                    break;
                case 2:
                    remote.setCommand(lightOff);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            remote.pressButton();
        }

        scanner.close();
    }
}
