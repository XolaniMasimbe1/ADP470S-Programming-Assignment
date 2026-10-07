package za.ac.cput;

import za.ac.cput.partA.Factorial;
import za.ac.cput.partA.Fibonacci;
import za.ac.cput.partB.BinarySearch;
import za.ac.cput.partB.HeapSort;
import za.ac.cput.partB.QuickSort;
import za.ac.cput.partB.SelectionSort;
import za.ac.cput.partC.Queue;
import za.ac.cput.partC.SinglyLinkedList;
import za.ac.cput.partC.Stack;
import za.ac.cput.partD.BinarySearchTree;
import za.ac.cput.partE.Graph;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Main class for ADP470S Programming Assignment.
 * Provides a console menu to demonstrate each part of the assignment.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = -1;
            }

            switch (choice) {
                case 1:
                    demonstratePartA();
                    break;
                case 2:
                    demonstratePartB();
                    break;
                case 3:
                    demonstratePartC();
                    break;
                case 4:
                    demonstratePartD();
                    break;
                case 5:
                    demonstratePartE();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
            if (choice != 0) {
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
            }

        } while (choice != 0);

        scanner.close();
    }

    /**
     * Displays the main menu.
     */
    private static void displayMenu() {
        System.out.println("===== ADP470S PROGRAMMING ASSIGNMENT =====");
        System.out.println();
        System.out.println("1. Part A - Recursive Algorithms");
        System.out.println("2. Part B - Searching and Sorting");
        System.out.println("3. Part C - Data Structures");
        System.out.println("4. Part D - Binary Search Tree");
        System.out.println("5. Part E - Graphs");
        System.out.println("0. Exit");
        System.out.println();
    }

    /**
     * Demonstrates Part A - Recursive Algorithms.
     */
    private static void demonstratePartA() {
        System.out.println("\n===== PART A - RECURSIVE ALGORITHMS =====\n");

        // Factorial Demo
        System.out.println("=== Factorial Demo ===\n");
        int[] factorialTestCases = {0, 1, 5, 10, 15};
        for (int n : factorialTestCases) {
            try {
                long result = Factorial.calculate(n);
                System.out.println("Factorial of " + n + " = " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error for n=" + n + ": " + e.getMessage());
            }
        }
        System.out.println("\nTesting invalid input (n = -5):");
        try {
            Factorial.calculate(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        // Fibonacci Demo
        System.out.println("=== Fibonacci Demo ===\n");
        System.out.println("First 15 Fibonacci numbers:");
        for (int i = 0; i <= 14; i++) {
            System.out.println("F(" + i + ") = " + Fibonacci.calculate(i));
        }
        System.out.println("\nSpecific test cases:");
        int[] fibonacciTestCases = {0, 1, 5, 10, 20};
        for (int n : fibonacciTestCases) {
            try {
                long result = Fibonacci.calculate(n);
                System.out.println("Fibonacci(" + n + ") = " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error for n=" + n + ": " + e.getMessage());
            }
        }
        System.out.println("\nTesting invalid input (n = -3):");
        try {
            Fibonacci.calculate(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n===== END OF PART A =====\n");
    }

    /**
     * Demonstrates Part B - Searching and Sorting.
     */
    private static void demonstratePartB() {
        System.out.println("\n===== PART B - SEARCHING AND SORTING =====\n");

        final int DATASET_SIZE = 1000;

        // Generate the original dataset
        System.out.println("Generating dataset of " + DATASET_SIZE + " random integers...");
        Random random = new Random(42);
        int[] originalDataset = new int[DATASET_SIZE];
        for (int i = 0; i < DATASET_SIZE; i++) {
            originalDataset[i] = random.nextInt(10000);
        }
        System.out.println("Dataset generated.\n");

        // Selection Sort
        System.out.println("--- Selection Sort ---");
        int[] selectionSortArray = Arrays.copyOf(originalDataset, originalDataset.length);
        long startTime = System.nanoTime();
        SelectionSort.sort(selectionSortArray);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Execution time: " + duration + " nanoseconds (" + (duration / 1_000_000.0) + " ms)");
        System.out.println("Verification: " + (SelectionSort.isSorted(selectionSortArray) ? "SORTED correctly" : "NOT sorted correctly"));
        System.out.println("First 10 elements: " + Arrays.toString(Arrays.copyOfRange(selectionSortArray, 0, 10)));
        System.out.println();

        // Quick Sort
        System.out.println("--- Quick Sort ---");
        int[] quickSortArray = Arrays.copyOf(originalDataset, originalDataset.length);
        startTime = System.nanoTime();
        QuickSort.sort(quickSortArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Execution time: " + duration + " nanoseconds (" + (duration / 1_000_000.0) + " ms)");
        System.out.println("Verification: " + (QuickSort.isSorted(quickSortArray) ? "SORTED correctly" : "NOT sorted correctly"));
        System.out.println("First 10 elements: " + Arrays.toString(Arrays.copyOfRange(quickSortArray, 0, 10)));
        System.out.println();

        // Heap Sort
        System.out.println("--- Heap Sort ---");
        int[] heapSortArray = Arrays.copyOf(originalDataset, originalDataset.length);
        startTime = System.nanoTime();
        HeapSort.sort(heapSortArray);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Execution time: " + duration + " nanoseconds (" + (duration / 1_000_000.0) + " ms)");
        System.out.println("Verification: " + (HeapSort.isSorted(heapSortArray) ? "SORTED correctly" : "NOT sorted correctly"));
        System.out.println("First 10 elements: " + Arrays.toString(Arrays.copyOfRange(heapSortArray, 0, 10)));
        System.out.println();

        // Binary Search
        System.out.println("--- Binary Search ---");
        int[] sortedArray = quickSortArray;
        int target1 = sortedArray[100];
        int target2 = 99999;
        int target3 = sortedArray[500];

        System.out.println("Recursive Binary Search:");
        System.out.println("Searching for " + target1 + ": " + (BinarySearch.recursiveSearch(sortedArray, target1) != -1 ? "Found" : "Not found"));
        System.out.println("Searching for " + target2 + ": " + (BinarySearch.recursiveSearch(sortedArray, target2) != -1 ? "Found" : "Not found"));
        System.out.println("Searching for " + target3 + ": " + (BinarySearch.recursiveSearch(sortedArray, target3) != -1 ? "Found" : "Not found"));

        System.out.println();

        System.out.println("Iterative Binary Search:");
        System.out.println("Searching for " + target1 + ": " + (BinarySearch.iterativeSearch(sortedArray, target1) != -1 ? "Found" : "Not found"));
        System.out.println("Searching for " + target2 + ": " + (BinarySearch.iterativeSearch(sortedArray, target2) != -1 ? "Found" : "Not found"));
        System.out.println("Searching for " + target3 + ": " + (BinarySearch.iterativeSearch(sortedArray, target3) != -1 ? "Found" : "Not found"));

        System.out.println("\n===== END OF PART B =====\n");
    }

    /**
     * Demonstrates Part C - Data Structures.
     */
    private static void demonstratePartC() {
        System.out.println("\n===== PART C - ELEMENTARY DATA STRUCTURES =====\n");

        // Singly Linked List
        System.out.println("--- Singly Linked List ---");
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("Inserting elements: 10, 20, 30, 40, 50");
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.display();
        System.out.println("Size: " + list.size());
        System.out.println("\nSearching for 30: " + (list.search(30) ? "Found" : "Not found"));
        System.out.println("Searching for 100: " + (list.search(100) ? "Found" : "Not found"));
        System.out.println("\nDeleting 30");
        list.delete(30);
        list.display();
        System.out.println("Size: " + list.size());
        System.out.println();

        // Stack
        System.out.println("--- Stack (Array-based) ---");
        Stack stack = new Stack(10);
        System.out.println("Pushing elements: 1, 2, 3, 4, 5");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        System.out.println("Size: " + stack.size());
        System.out.println("\nPeek: " + stack.peek());
        System.out.println("Popping: " + stack.pop());
        stack.display();
        System.out.println("Size: " + stack.size());
        System.out.println("\n--- String Reversal using Stack ---");
        String original = "Hello World";
        String reversed = Stack.reverseString(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
        System.out.println();

        // Queue
        System.out.println("--- Queue (Circular Array) ---");
        Queue queue = new Queue(10);
        System.out.println("Enqueueing customers: 101, 102, 103, 104, 105");
        queue.enqueue(101);
        queue.enqueue(102);
        queue.enqueue(103);
        queue.enqueue(104);
        queue.enqueue(105);
        queue.display();
        System.out.println("Size: " + queue.size());
        System.out.println("\nPeek (next customer): " + queue.peek());
        System.out.println("\nServing customers:");
        System.out.println("Serving customer: " + queue.dequeue());
        queue.display();
        System.out.println("Size: " + queue.size());
        System.out.println("\nNew customers arriving: 106, 107");
        queue.enqueue(106);
        queue.enqueue(107);
        queue.display();
        System.out.println("Size: " + queue.size());
        System.out.println();

        System.out.println("===== END OF PART C =====\n");
    }

    /**
     * Demonstrates Part D - Binary Search Tree.
     */
    private static void demonstratePartD() {
        System.out.println("\n===== PART D - BINARY SEARCH TREE =====\n");

        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Inserting elements: 50, 30, 70, 20, 40, 60, 80");
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("\nTraversals after insertion:");
        bst.inOrderTraversal();
        bst.preOrderTraversal();
        bst.postOrderTraversal();

        System.out.println("\nSearch operations:");
        System.out.println("Searching for 40: " + (bst.search(40) ? "Found" : "Not found"));
        System.out.println("Searching for 25: " + (bst.search(25) ? "Found" : "Not found"));
        System.out.println("Searching for 70: " + (bst.search(70) ? "Found" : "Not found"));

        System.out.println("\nDeleting 20 (leaf node): " + bst.delete(20));
        bst.inOrderTraversal();

        System.out.println("Deleting 30 (node with one child): " + bst.delete(30));
        bst.inOrderTraversal();

        System.out.println("Deleting 50 (node with two children): " + bst.delete(50));
        bst.inOrderTraversal();

        System.out.println("\nInserting more elements: 10, 90, 35");
        bst.insert(10);
        bst.insert(90);
        bst.insert(35);

        System.out.println("\nFinal traversals:");
        bst.inOrderTraversal();
        bst.preOrderTraversal();
        bst.postOrderTraversal();

        System.out.println("\nNote:");
        System.out.println("- Average-case complexity: O(log n)");
        System.out.println("- Worst-case complexity: O(n) when tree becomes unbalanced");
        System.out.println("- A BST can become unbalanced if elements are inserted in sorted order");

        System.out.println("\n===== END OF PART D =====\n");
    }

    /**
     * Demonstrates Part E - Graphs.
     */
    private static void demonstratePartE() {
        System.out.println("\n===== PART E - GRAPHS =====\n");

        Graph cityGraph = new Graph(6);

        cityGraph.setVertexName(0, "Cape Town");
        cityGraph.setVertexName(1, "Johannesburg");
        cityGraph.setVertexName(2, "Durban");
        cityGraph.setVertexName(3, "Port Elizabeth");
        cityGraph.setVertexName(4, "Bloemfontein");
        cityGraph.setVertexName(5, "Pretoria");

        System.out.println("Creating a transport network with 6 cities:");
        System.out.println("0: Cape Town");
        System.out.println("1: Johannesburg");
        System.out.println("2: Durban");
        System.out.println("3: Port Elizabeth");
        System.out.println("4: Bloemfontein");
        System.out.println("5: Pretoria");

        System.out.println("\nAdding roads between cities:");
        cityGraph.addEdge(0, 3);
        System.out.println("Cape Town - Port Elizabeth");
        cityGraph.addEdge(0, 4);
        System.out.println("Cape Town - Bloemfontein");
        cityGraph.addEdge(1, 4);
        System.out.println("Johannesburg - Bloemfontein");
        cityGraph.addEdge(1, 5);
        System.out.println("Johannesburg - Pretoria");
        cityGraph.addEdge(2, 3);
        System.out.println("Durban - Port Elizabeth");
        cityGraph.addEdge(2, 4);
        System.out.println("Durban - Bloemfontein");
        cityGraph.addEdge(3, 4);
        System.out.println("Port Elizabeth - Bloemfontein");

        System.out.println();
        cityGraph.displayAdjacencyMatrix();
        System.out.println();

        System.out.println("--- Depth-First Search (DFS) ---");
        cityGraph.dfs(0);
        cityGraph.dfs(1);
        System.out.println();

        System.out.println("--- Breadth-First Search (BFS) ---");
        cityGraph.bfs(0);
        cityGraph.bfs(1);
        System.out.println();

        System.out.println("--- Shortest Path (by number of edges) ---");

        System.out.println("\nFinding shortest path from Cape Town to Johannesburg:");
        int[] path1 = cityGraph.findShortestPath(0, 1);
        if (path1 != null) {
            System.out.print("Path: ");
            for (int i = 0; i < path1.length; i++) {
                System.out.print(cityGraph.getVertexName(path1[i]));
                if (i < path1.length - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println(" (" + (path1.length - 1) + " edges)");
        } else {
            System.out.println("No path found");
        }

        System.out.println("\nFinding shortest path from Cape Town to Durban:");
        int[] path2 = cityGraph.findShortestPath(0, 2);
        if (path2 != null) {
            System.out.print("Path: ");
            for (int i = 0; i < path2.length; i++) {
                System.out.print(cityGraph.getVertexName(path2[i]));
                if (i < path2.length - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println(" (" + (path2.length - 1) + " edges)");
        } else {
            System.out.println("No path found");
        }

        System.out.println("\nFinding shortest path from Pretoria to Durban:");
        int[] path3 = cityGraph.findShortestPath(5, 2);
        if (path3 != null) {
            System.out.print("Path: ");
            for (int i = 0; i < path3.length; i++) {
                System.out.print(cityGraph.getVertexName(path3[i]));
                if (i < path3.length - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println(" (" + (path3.length - 1) + " edges)");
        } else {
            System.out.println("No path found");
        }

        System.out.println("\nFinding shortest path from Johannesburg to Port Elizabeth:");
        int[] path4 = cityGraph.findShortestPath(1, 3);
        if (path4 != null) {
            System.out.print("Path: ");
            for (int i = 0; i < path4.length; i++) {
                System.out.print(cityGraph.getVertexName(path4[i]));
                if (i < path4.length - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println(" (" + (path4.length - 1) + " edges)");
        } else {
            System.out.println("No path found");
        }

        System.out.println("\nNote: The shortest path is measured by the number of edges,");
        System.out.println("not by geographical distance.");
        System.out.println("This is a transport network demonstrating connectivity between cities.");

        System.out.println("\n===== END OF PART E =====\n");
    }
}
