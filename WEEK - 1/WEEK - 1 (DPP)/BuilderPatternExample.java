package com.mycompany.builderpatternexample;

public class BuilderPatternExample {

    public static void main(String[] args) {
        // Create a Computer using the Builder pattern
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 3080")
            .setPowerSupply("850W")
            .build();

        Computer officeComputer = new Computer.Builder("Intel i5", "16GB")
            .setStorage("512GB SSD")
            .build();

        System.out.println(gamingComputer);
        System.out.println(officeComputer);
    }

    // Computer class
    static class Computer {
        // Required parameters
        private final String CPU;
        private final String RAM;
        
        // Optional parameters
        private final String storage;
        private final String graphicsCard;
        private final String powerSupply;

        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
            this.powerSupply = builder.powerSupply;
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + 
                   ", Storage=" + storage + 
                   ", GraphicsCard=" + graphicsCard + 
                   ", PowerSupply=" + powerSupply + "]";
        }

        // Builder class
        public static class Builder {
            // Required parameters
            private final String CPU;
            private final String RAM;
            
            // Optional parameters
            private String storage;
            private String graphicsCard;
            private String powerSupply;

            public Builder(String CPU, String RAM) {
                this.CPU = CPU;
                this.RAM = RAM;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Builder setPowerSupply(String powerSupply) {
                this.powerSupply = powerSupply;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }
}
