public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("Starting the program...\n");

        // Array Out of Bounds Exception
        try {
            int[] numbers = {10, 20, 30};
            System.out.println("Trying to access the 5th item in a 3-item array...");
            
            // This causes an ArrayIndexOutOfBoundsException (valid indexes are 0, 1, 2)
            System.out.println(numbers[4]); 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error Caught: You tried to grab an item from a spot in the list that doesn't exist.");
        }

        System.out.println("\nMoving on to math problems...\n");

        // Divide by Zero Exception
        try {
            int a = 50;
            int b = 0;
            System.out.println("Trying to divide " + a + " by " + b + "...");
            
            // This causes an ArithmeticException
            int result = a / b; 
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error Caught: You cannot divide a number by zero.");
        }

        // This should read if everything goes right
        System.out.println("\nSuccess! The program caught the errors and closed without crashing.");
    }
}
