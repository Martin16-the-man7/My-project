import java.util.ArrayList;
import java.util.Collections;

// Original Base Class now implementing the Comparable interface
public class SmartPhone implements Comparable<SmartPhone> { 
    private String modelName; 
    private int storageGB; 
    private double operatingSystemVersion; 

    // Constructor to initialize base SmartPhone attributes
    public SmartPhone(String modelName, int storageGB, double operatingSystemVersion) { 
        this.modelName = modelName; 
        this.storageGB = storageGB; 
        this.operatingSystemVersion = operatingSystemVersion; 
    } 

    // Method to upgrade the phone's specs
    public void upgradePhone(String newModel, int extraStorage, double osVersionIncrease) { 
        this.modelName = newModel; 
        this.storageGB += extraStorage; 
        this.operatingSystemVersion += osVersionIncrease; 
        System.out.println("\n--- Upgrade Complete for " + this.modelName + "! ---"); 
    } 

    // Method to print detailed specs
    public void displayDetails() { 
        System.out.println("Phone Model: " + this.modelName); 
        System.out.println("Storage Capacity: " + this.storageGB + " GB"); 
        System.out.println("OS Version: v" + String.format("%.1f", this.operatingSystemVersion)); 
    } 

    // =========================================================================
    // COMPARABLE INTERFACE IMPLEMENTATION
    // =========================================================================
    /**
     * Compares this SmartPhone with another SmartPhone for order.
     * Sorts primarily by storage capacity (ascending). 
     * If storage is equal, it uses the OS version as a tie-breaker.
     */
    @Override
    public int compareTo(SmartPhone other) {
        // Compare storage capacity first
        if (this.storageGB != other.storageGB) {
            return Integer.compare(this.storageGB, other.storageGB);
        }
        // Tie-breaker: compare operating system version
        return Double.compare(this.operatingSystemVersion, other.operatingSystemVersion);
    }

    // Overriding toString() makes printing the ArrayList clean and readable
    @Override
    public String toString() {
        return String.format("%-22s | Storage: %4d GB | OS: v%.1f", 
                             this.modelName, this.storageGB, this.operatingSystemVersion);
    }

    // =========================================================================
    // SUBCLASS 1: GamingPhone
    // =========================================================================
    public static class GamingPhone extends SmartPhone {
        // Specific variables for this subclass
        private int screenRefreshRateHz;
        private boolean liquidCoolingActive;

        // Constructor calling the superclass (SmartPhone) constructor
        public GamingPhone(String modelName, int storageGB, double operatingSystemVersion, 
                           int screenRefreshRateHz, boolean liquidCoolingActive) {
            super(modelName, storageGB, operatingSystemVersion);
            this.screenRefreshRateHz = screenRefreshRateHz;
            this.liquidCoolingActive = liquidCoolingActive;
        }

        // Override toString to include GamingPhone-specific details when printing the list
        @Override
        public String toString() {
            return super.toString() + " | Refresh Rate: " + screenRefreshRateHz + "Hz | Cooling: " + liquidCoolingActive;
        }
    }

    // =========================================================================
    // MAIN METHOD
    // =========================================================================
    public static void main(String[] args) {
        // Create an ArrayList to hold SmartPhone objects (including subclasses)
        ArrayList<SmartPhone> phoneInventory = new ArrayList<>();

        // Add 10 objects of varying storage capacities and OS versions
        phoneInventory.add(new SmartPhone("Pixel 8", 128, 14.0));
        phoneInventory.add(new GamingPhone("ROG Phone 8 Pro", 512, 14.0, 165, true));
        phoneInventory.add(new SmartPhone("iPhone 15", 256, 17.2));
        phoneInventory.add(new SmartPhone("Galaxy S24 Ultra", 1024, 14.1));
        phoneInventory.add(new GamingPhone("RedMagic 9 Pro", 256, 14.0, 120, true));
        phoneInventory.add(new SmartPhone("iPhone SE", 64, 16.5));
        phoneInventory.add(new SmartPhone("OnePlus 12", 512, 14.0));
        phoneInventory.add(new GamingPhone("Legion Duel 2", 256, 11.0, 144, true));
        phoneInventory.add(new SmartPhone("Moto G Power", 128, 13.0));
        phoneInventory.add(new SmartPhone("Xperia 1 V", 256, 13.5));

        // 1. Print the ArrayList BEFORE sorting
        System.out.println("=== UNSORTED PHONE LIST ===");
        for (SmartPhone phone : phoneInventory) {
            System.out.println(phone);
        }

        // 2. Sort the ArrayList using Java's built-in Collections.sort()
        // This automatically uses the compareTo() method we wrote above
        Collections.sort(phoneInventory);

        // 3. Print the ArrayList AFTER sorting
        System.out.println("\n=== SORTED PHONE LIST (By Storage, then OS) ===");
        for (SmartPhone phone : phoneInventory) {
            System.out.println(phone);
        }
    }
}
