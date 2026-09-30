// Student Name: [Your Name]
// Email: [Your Email]
// For CTE software development 1 
// Instructor Mr Gross

class bubbleSort {

    public static int[] swapTwoArrayElements(int[] arrayToSwap, int lowerIndex) {
        int temp;
        temp = arrayToSwap[lowerIndex];
        arrayToSwap[lowerIndex] = arrayToSwap[lowerIndex + 1];
        arrayToSwap[lowerIndex + 1] = temp;
        return arrayToSwap;
    }

    public static void main(String[] args) {
        int[] arrayToSort = {1, 3, 4, 5, 1, 23, 57, 126, 4, 543, 345, 23, 12, 45, 67, 97};

        // Print the array before sorting
        System.out.println("Original Array:");
        for (int num : arrayToSort) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Flag variable to track if any swaps occurred in a pass
        boolean doSwap = true;

        // While loop runs as long as a swap was made in the previous pass
        while (doSwap) {
            // Assume no swaps will happen in this pass
            doSwap = false;

            // For loop checks each pair of adjacent elements.
            // We stop at arrayToSort.length - 1 to prevent going out of bounds.
            for (int i = 0; i < arrayToSort.length - 1; i++) {
                // If the lower element is larger than the higher element, they need to swap
                if (arrayToSort[i] > arrayToSort[i + 1]) {
                    // Call the swap function and assign the result back to our array
                    arrayToSort = swapTwoArrayElements(arrayToSort, i);
                    
                    // Set flag to true so the while loop knows to run at least one more time
                    doSwap = true;
                }
            }
        }

        // Print the array after sorting to verify it works
        System.out.println("\nSorted Array:");
        for (int num : arrayToSort) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
