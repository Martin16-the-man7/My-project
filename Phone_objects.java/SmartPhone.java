public class SmartPhone {
    // 3 Private attributes (cannot be accessed directly from outside the class)
    private String modelName;
    private int storageGB;
    private double operatingSystemVersion;

    // Constructor to initialize the object
    public SmartPhone(String modelName, int storageGB, double operatingSystemVersion) {
        this.modelName = modelName;
        this.storageGB = storageGB;
        this.operatingSystemVersion = operatingSystemVersion;
    }

    // 1 Behavior (method) that changes all three attributes at once
    public void upgradePhone(String newModel, int extraStorage, double osVersionIncrease) {
        this.modelName = newModel;
        this.storageGB += extraStorage;                 // Increases current storage
        this.operatingSystemVersion += osVersionIncrease; // Increases current OS version
        System.out.println("\n--- Upgrade Complete for " + this.modelName + "! ---");
    }

    // Method to display the current state of the object
    public void displayDetails() {
        System.out.println("Phone Model: " + this.modelName);
        System.out.println("Storage Capacity: " + this.storageGB + " GB");
        System.out.println("OS Version: v" + String.format("%.1f", this.operatingSystemVersion));
    }

    // Main method to test the custom object
    public static void main(String[] args) {
        // 1. Create at least three distinct objects
        SmartPhone phone1 = new SmartPhone("Phonex 12", 128, 1.0);
        SmartPhone phone2 = new SmartPhone("Nebula 5G", 64, 9.0);
        SmartPhone phone3 = new SmartPhone("Quantum Lite", 256, 4.2);
        
        System.out.println("=== INITIAL PHONE DETAILS ===");
        System.out.println("[Phone 1]");
        phone1.displayDetails();
        System.out.println("\n[Phone 2]");
        phone2.displayDetails();
        System.out.println("\n[Phone 3]");
        phone3.displayDetails();

        // 2. Modify attributes and use behaviors to do something
        System.out.println("\n=== PERFORMING PHONE UPGRADES ===");
        
        // Upgrade Phone 1: Trade-in for next gen model, double storage, minor OS patch
        phone1.upgradePhone("Phonex 13 Pro", 128, 1.2);
        phone1.displayDetails();

        // Upgrade Phone 2: Standard software/hardware overhaul
        phone2.upgradePhone("Nebula Pro", 64, 1.0);
        phone2.displayDetails();

        // Upgrade Phone 3: Massive specs bump
        phone3.upgradePhone("Quantum Ultra Max", 512, 0.8);
        phone3.displayDetails();
        
        System.out.println("\n=== ALL SYSTEM UPDATES COMPLETE ===");
    }
}