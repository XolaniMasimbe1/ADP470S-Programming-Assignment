package za.ac.cput.partA;

/**
 * Recursive implementation of the Fibonacci sequence.
 * Base cases: fibonacci(0) = 0, fibonacci(1) = 1.
 */
public class Fibonacci {

    /**
     * Calculates the nth Fibonacci number recursively.
     *
     * @param n the position in the Fibonacci sequence (0-indexed)
     * @return the nth Fibonacci number
     * @throws IllegalArgumentException if n is negative
     */
    public static long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci is not defined for negative numbers");
        }
        // Base cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // Recursive case: F(n) = F(n-1) + F(n-2)
        return calculate(n - 1) + calculate(n - 2);
    }

    /**
     * Demo method to test the Fibonacci implementation.
     */
    public static void demo() {
        System.out.println("=== Fibonacci Demo ===\n");

        System.out.println("First 15 Fibonacci numbers:");
        for (int i = 0; i <= 14; i++) {
            System.out.println("F(" + i + ") = " + calculate(i));
        }

        // Test specific values
        System.out.println("\nSpecific test cases:");
        int[] testCases = {0, 1, 5, 10, 20};
        for (int n : testCases) {
            try {
                long result = calculate(n);
                System.out.println("Fibonacci(" + n + ") = " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error for n=" + n + ": " + e.getMessage());
            }
        }

        // Test invalid input
        System.out.println("\nTesting invalid input (n = -3):");
        try {
            calculate(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
