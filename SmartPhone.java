import java.util.ArrayList;

// Original Base Class
public class SmartPhone { 
    private String modelName; 
    private int storageGB; 
    private double operatingSystemVersion; 

    public SmartPhone(String modelName, int storageGB, double operatingSystemVersion) { 
        this.modelName = modelName; 
        this.storageGB = storageGB; 
        this.operatingSystemVersion = operatingSystemVersion; 
    } 

    public void upgradePhone(String newModel, int extraStorage, double osVersionIncrease) { 
        this.modelName = newModel; 
        this.storageGB += extraStorage; 
        this.operatingSystemVersion += osVersionIncrease; 
        System.out.println("\n--- Upgrade Complete for " + this.modelName + "! ---"); 
    } 

    public void displayDetails() { 
        System.out.println("Phone Model: " + this.modelName); 
        System.out.println("Storage Capacity: " + this.storageGB + " GB"); 
        System.out.println("OS Version: v" + String.format("%.1f", this.operatingSystemVersion)); 
    } 

    // =========================================================================
    // SUBCLASS 1: GamingPhone
    // =========================================================================
    public static class GamingPhone extends SmartPhone {
        // Specific variables for this subclass
        private int screenRefreshRateHz;
        private boolean liquidCoolingActive;

        // Constructor calling the parent constructor using super()
        public GamingPhone(String modelName, int storageGB, double operatingSystemVersion, int screenRefreshRateHz) {
            super(modelName, storageGB, operatingSystemVersion);
            this.screenRefreshRateHz = screenRefreshRateHz;
            this.liquidCoolingActive = false; // Default off
        }

        // Specific method to toggle cooling mode
        public void toggleLiquidCooling() {
            this.liquidCoolingActive = !this.liquidCoolingActive;
            System.out.println(">> Liquid Cooling Status: " + (this.liquidCoolingActive ? "OVERCLOCKED & ACTIVE" : "DISABLED"));
        }

        // Specific method to boost screen performance
        public void boostRefreshRate(int increase) {
            this.screenRefreshRateHz += increase;
            System.out.println(">> Performance Boost: Screen refresh rate increased to " + this.screenRefreshRateHz + "Hz!");
        }

        // Overriding display details to append specific data
        @Override
        public void displayDetails() {
            super.displayDetails();
            System.out.println("Screen Refresh Rate: " + this.screenRefreshRateHz + "Hz");
            System.out.println("Liquid Cooling: " + (this.liquidCoolingActive ? "Active" : "Inactive"));
        }
    }

    // =========================================================================
    // SUBCLASS 2: BusinessPhone
    // =========================================================================
    public static class BusinessPhone extends SmartPhone {
        // Specific data structure (Arraylist) to hold security accounts
        private ArrayList<String> encryptedAccounts;
        private String biometricLockType;

        public BusinessPhone(String modelName, int storageGB, double operatingSystemVersion, String biometricLockType) {
            super(modelName, storageGB, operatingSystemVersion);
            this.biometricLockType = biometricLockType;
            this.encryptedAccounts = new ArrayList<>();
        }

        // Specific method utilizing the collection data structure
        public void registerSecuredAccount(String accountName) {
            this.encryptedAccounts.add(accountName);
            System.out.println(">> Security Alert: Account '" + accountName + "' has been successfully encrypted.");
        }

        // Specific method to update hardware security configuration
        public void updateBiometrics(String newLockType) {
            this.biometricLockType = newLockType;
            System.out.println(">> Security Configuration Updated to: " + this.biometricLockType);
        }

        @Override
        public void displayDetails() {
            super.displayDetails();
            System.out.println("Biometric Lock Security: " + this.biometricLockType);
            System.out.println("Total Encrypted Corporate Profiles: " + this.encryptedAccounts.size());
            if (!this.encryptedAccounts.isEmpty()) {
                System.out.println("   Active Accounts: " + this.encryptedAccounts);
            }
        }
    }

    // =========================================================================
    // MAIN WRAPPER METHOD
    // =========================================================================
    public static void main(String[] args) { 
        // 1. Create objects of all three types
        SmartPhone standardPhone = new SmartPhone("Phonex 12", 128, 1.0); 
        GamingPhone gamerPhone = new GamingPhone("Apex Overlord 9", 256, 14.0, 120);
        BusinessPhone corporatePhone = new BusinessPhone("SecureBook Pro", 512, 11.2, "Fingerprint Scanner");

        System.out.println("=== INITIAL OBJECT STATES ==="); 
        System.out.println("[Standard Phone Base Object]"); 
        standardPhone.displayDetails(); 

        System.out.println("\n[Subclass Object: GamingPhone]"); 
        gamerPhone.displayDetails(); 

        System.out.println("\n[Subclass Object: BusinessPhone]"); 
        corporatePhone.displayDetails(); 

        // 2. Modify attributes using parent behaviors and subclass specific methods
        System.out.println("\n=== MODIFYING OBJECTS AND PERFORMING ACTIONS ==="); 
        
        // Modifying the standard phone
        standardPhone.upgradePhone("Phonex 13 Pro", 128, 1.2); 
        standardPhone.displayDetails(); 

        // Modifying the Gaming Phone (uses both inherited and specific behaviors)
        gamerPhone.upgradePhone("Apex Overlord 9 Turbo", 128, 0.5); // Inherited method
        gamerPhone.toggleLiquidCooling();                          // Subclass method
        gamerPhone.boostRefreshRate(24);                            // Subclass method
        gamerPhone.displayDetails(); 

        // Modifying the Business Phone (uses both inherited and specific behaviors)
        corporatePhone.upgradePhone("SecureBook Enterprise", 512, 1.0); // Inherited method
        corporatePhone.updateBiometrics("3D Facial Recognition");      // Subclass method
        corporatePhone.registerSecuredAccount("Main_Corporate_Vault"); // Subclass method
        corporatePhone.registerSecuredAccount("Offshore_Payroll_DB");   // Subclass method
        corporatePhone.displayDetails(); 

        System.out.println("\n=== ALL OBJECT OPERATIONS SUCCESSFUL ==="); 
    } 
}
