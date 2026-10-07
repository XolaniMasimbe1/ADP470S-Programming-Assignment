package za.ac.cput.partB;

/**
 * Implementation of Binary Search with both recursive and iterative approaches.
 * Time Complexity: O(log n)
 * Space Complexity: O(1) iterative, O(log n) recursive due to call stack
 */
public class BinarySearch {

    /**
     * Iterative Binary Search.
     *
     * @param arr the sorted array to search in
     * @param target the value to search for
     * @return index of target if found, -1 otherwise
     */
    public static int iterativeSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }

    /**
     * Recursive Binary Search.
     *
     * @param arr the sorted array to search in
     * @param target the value to search for
     * @param left starting index
     * @param right ending index
     * @return index of target if found, -1 otherwise
     */
    public static int recursiveSearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Base case: target not found
        }

        int mid = left + (right - left) / 2;

        // Check if target is present at mid
        if (arr[mid] == target) {
            return mid;
        }

        // If target is greater, search right half
        if (arr[mid] < target) {
            return recursiveSearch(arr, target, mid + 1, right);
        }

        // If target is smaller, search left half
        return recursiveSearch(arr, target, left, mid - 1);
    }

    /**
     * Overloaded method for recursive search on entire array.
     */
    public static int recursiveSearch(int[] arr, int target) {
        return recursiveSearch(arr, target, 0, arr.length - 1);
    }
}
