package za.ac.cput.partB;

/**
 * Recursive implementation of Quick Sort.
 * Time Complexity: O(n log n) average, O(n^2) worst case
 * Space Complexity: O(log n) average due to recursion stack
 */
public class QuickSort {

    /**
     * Main method to sort an array using Quick Sort.
     *
     * @param arr the array to be sorted
     * @param low starting index
     * @param high ending index
     */
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before and after partition
            sort(arr, low, pivotIndex - 1);
            sort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Overloaded method for convenience - sorts the entire array.
     */
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * Takes the last element as pivot, places the pivot element at its correct
     * position in sorted array, and places all smaller elements to left of pivot
     * and all greater elements to right of pivot.
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Verifies if an array is sorted in ascending order.
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
