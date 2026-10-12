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
        System.out.println("\n--- Upgrade Complete! ---");
    }

    // Method to display the current state of the object
    public void displayDetails() {
        System.out.println("Phone Model: " + this.modelName);
        System.out.println("Storage Capacity: " + this.storageGB + " GB");
        System.out.println("OS Version: v" + this.operatingSystemVersion);
    }

    // Main method to test the custom object
    public static void main(String[] args) {
        // Creating the custom object
        SmartPhone myPhone = new SmartPhone("Phonex 12", 128, 1.0);
        
        System.out.println("Initial Phone Details:");
        myPhone.displayDetails();

        // Modifying the attributes strictly through the behavior method
        myPhone.upgradePhone("Phonex 13 Pro", 128, 1.2);

        System.out.println("Updated Phone Details:");
        myPhone.displayDetails();
    }
}
