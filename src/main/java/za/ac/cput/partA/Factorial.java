package za.ac.cput.partA;

/**
 * Recursive implementation of the factorial algorithm.
 * Base case: factorial of 0 or 1 is 1.
 */
public class Factorial {

    /**
     * Calculates the factorial of a non-negative integer recursively.
     *
     * @param n the number to calculate factorial for
     * @return factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public static long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        // Base case: factorial of 0 or 1 is 1
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive case: n! = n * (n-1)!
        return n * calculate(n - 1);
    }

    /**
     * Demo method to test the factorial implementation.
     */
    public static void demo() {
        System.out.println("=== Factorial Demo ===\n");

        int[] testCases = {0, 1, 5, 10, 15};

        for (int n : testCases) {
            try {
                long result = calculate(n);
                System.out.println("Factorial of " + n + " = " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error for n=" + n + ": " + e.getMessage());
            }
        }

        // Test invalid input
        System.out.println("\nTesting invalid input (n = -5):");
        try {
            calculate(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
