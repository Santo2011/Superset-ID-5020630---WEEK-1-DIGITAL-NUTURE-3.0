package com.mycompany.proxypatternexample;

// Step 2: Define Subject Interface
interface Image {
    void display();
}

// Step 3: Implement Real Subject Class
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

// Step 4: Implement Proxy Class
class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

// Step 5: Test the Proxy Implementation
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        image.display(); // loading necessary
        image.display(); // loading not necessary
    }
}
