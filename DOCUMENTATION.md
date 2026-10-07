# ADP470S Programming Assignment

**Student:** XolaniMasimbe1  
**Email:** xmasimbe965@gmail.com  
**Course:** Advanced Diploma in ICT: Application Development  
**Technology:** Java, Object-Oriented Programming, IntelliJ IDEA

---

## Table of Contents

1. [Project Overview](#project-overview)
2. [Project Structure](#project-structure)
3. [How to Run the Project](#how-to-run-the-project)
4. [Part A - Recursive Algorithms](#part-a---recursive-algorithms)
5. [Part B - Searching and Sorting](#part-b---searching-and-sorting)
6. [Part C - Elementary Data Structures](#part-c---elementary-data-structures)
7. [Part D - Binary Search Tree](#part-d---binary-search-tree)
8. [Part E - Graphs](#part-e---graphs)
9. [Conclusion](#conclusion)

---

## Project Overview

This project implements fundamental algorithms and data structures as part of the ADP470S Programming Assignment. The assignment covers:

- **Part A:** Recursive algorithms (Factorial and Fibonacci)
- **Part B:** Searching and sorting algorithms (Selection Sort, Quick Sort, Heap Sort, Binary Search)
- **Part C:** Elementary data structures (Linked List, Stack, Queue)
- **Part D:** Binary Search Tree (BST)
- **Part E:** Graphs with adjacency matrix (DFS, BFS, Shortest Path)

All implementations are done from scratch using pure Java, without external libraries or frameworks.

---

## Project Structure

```
ADP470S-Programming-Assignment/
├── src/
│   └── main/
│       └── java/
│           └── za/
│               └── ac/
│                   └── cput/
│                       ├── Main.java                    # Main menu system
│                       ├── partA/
│                       │   ├── Factorial.java            # Recursive factorial
│                       │   └── Fibonacci.java            # Recursive fibonacci
│                       ├── partB/
│                       │   ├── SelectionSort.java        # Iterative selection sort
│                       │   ├── QuickSort.java            # Recursive quick sort
│                       │   ├── HeapSort.java              # Heap sort
│                       │   └── BinarySearch.java          # Recursive & iterative binary search
│                       ├── partC/
│                       │   ├── SinglyLinkedList.java     # Linked list from scratch
│                       │   ├── Stack.java                 # Array-based stack
│                       │   └── Queue.java                 # Circular array queue
│                       ├── partD/
│                       │   └── BinarySearchTree.java     # BST from scratch
│                       └── partE/
│                           └── Graph.java                 # Adjacency matrix graph
├── pom.xml                                            # Maven configuration
└── DOCUMENTATION.md                                   # This file
```

---

## How to Run the Project

### Using IntelliJ IDEA

1. Open IntelliJ IDEA
2. Click "Open" and select the project folder
3. Wait for Maven to import dependencies
4. Right-click on `Main.java`
5. Select "Run 'Main.main()'"
6. Use the menu to select which part to demonstrate

### Using Command Line

**Compile:**
```bash
javac -d target/classes src/main/java/za/ac/cput/**/*.java
```

**Run:**
```bash
java -cp target/classes za.ac.cput.Main
```

**Or using Maven:**
```bash
mvn compile exec:java -Dexec.mainClass="za.ac.cput.Main"
```

---

## Part A - Recursive Algorithms

### 1. Factorial

**Implementation:** Recursive factorial algorithm with base case handling.

**Algorithm:**
- Base case: factorial(0) = factorial(1) = 1
- Recursive case: factorial(n) = n × factorial(n-1)
- Invalid input handling: throws exception for negative numbers

**Time Complexity:** O(n)  
**Space Complexity:** O(n) due to recursion stack

**Difference between recursive and iterative approaches:**
- **Recursive:** More elegant, uses call stack, can cause stack overflow for large n
- **Iterative:** More efficient in space, doesn't use call stack, less elegant code

### 2. Fibonacci

**Implementation:** Recursive algorithm to generate the nth Fibonacci number.

**Algorithm:**
- Base cases: fibonacci(0) = 0, fibonacci(1) = 1
- Recursive case: fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)
- Invalid input handling: throws exception for negative numbers

**Time Complexity:** O(2^n) - exponential due to repeated calculations  
**Space Complexity:** O(n) due to recursion stack depth

**Note:** This naive recursive implementation is inefficient for large numbers. An iterative approach or memoization would be more efficient.

---

## Part B - Searching and Sorting

### 1. Selection Sort

**Implementation:** Iterative selection sort algorithm.

**Algorithm:**
- Find the minimum element in the unsorted portion
- Swap it with the first unsorted element
- Repeat for the remaining unsorted portion

**Time Complexity:** O(n²) - always performs same number of comparisons  
**Space Complexity:** O(1) - sorts in-place

**Practical Execution Time:** Slow for large datasets (tested with 1000 elements)

### 2. Quick Sort

**Implementation:** Recursive quick sort with partition scheme.

**Algorithm:**
- Choose a pivot element (last element)
- Partition array around pivot (smaller elements left, larger right)
- Recursively sort left and right partitions

**Time Complexity:**
- Average case: O(n log n)
- Worst case: O(n²) - when pivot is always smallest/largest element

**Space Complexity:** O(log n) - average case due to recursion stack

**Practical Execution Time:** Fast for large datasets (tested with 1000 elements)

### 3. Heap Sort

**Implementation:** Heap sort using max-heap data structure.

**Algorithm:**
- Build a max-heap from the array
- Repeatedly extract the maximum element and place it at the end
- Heapify the remaining elements

**Time Complexity:** O(n log n) - always  
**Space Complexity:** O(1) - sorts in-place

**Practical Execution Time:** Fast and consistent (tested with 1000 elements)

### 4. Binary Search

**Implementation:** Both recursive and iterative binary search.

**Algorithm:**
- Requires sorted array
- Compare target with middle element
- If target equals middle, return index
- If target is smaller, search left half
- If target is larger, search right half

**Time Complexity:** O(log n)  
**Space Complexity:**
- Iterative: O(1)
- Recursive: O(log n) due to recursion stack

**Differences between Recursive and Iterative Binary Search:**
- **Recursive:** More elegant, uses call stack, slightly more memory
- **Iterative:** More efficient in space, no recursion overhead

**Testing:** All sorting algorithms tested with the same dataset of 1000 random integers using copied arrays to ensure fair comparison.

---

## Part C - Elementary Data Structures

### 1. Singly Linked List

**Implementation:** Implemented from scratch with Node class.

**Operations:**
- `insert(data)`: Insert at beginning - O(1)
- `insertAtEnd(data)`: Insert at end - O(n)
- `delete(data)`: Delete first occurrence - O(n)
- `search(data)`: Search for value - O(n)

**Time Complexity:**
- Insert at head: O(1)
- Insert at tail: O(n)
- Delete: O(n)
- Search: O(n)

**Space Complexity:** O(n) where n is number of elements

### 2. Stack (Array-based)

**Implementation:** Array-based stack with fixed capacity.

**Operations:**
- `push(data)`: Add element to top - O(1)
- `pop()`: Remove and return top element - O(1)
- `peek()`: Return top element without removing - O(1)
- `isEmpty()`: Check if stack is empty - O(1)
- `isFull()`: Check if stack is full - O(1)

**Time Complexity:** All operations are O(1)  
**Space Complexity:** O(capacity)

**Demonstration:** String reversal using stack - pushes all characters, then pops to reverse.

### 3. Queue (Circular Array)

**Implementation:** Circular array-based queue with fixed capacity.

**Operations:**
- `enqueue(data)`: Add element to rear - O(1)
- `dequeue()`: Remove and return front element - O(1)
- `peek()`: Return front element without removing - O(1)
- `isEmpty()`: Check if queue is empty - O(1)
- `isFull()`: Check if queue is full - O(1)

**Time Complexity:** All operations are O(1)  
**Space Complexity:** O(capacity)

**Demonstration:** Bank queue simulation - customers arrive and are served in FIFO order.

**Note:** Circular array allows efficient reuse of space when elements are dequeued.

---

## Part D - Binary Search Tree

**Implementation:** BST implemented from scratch with Node class.

**Operations:**
- `insert(data)`: Insert new value - O(log n) average, O(n) worst
- `search(data)`: Search for value - O(log n) average, O(n) worst
- `delete(data)`: Delete value - O(log n) average, O(n) worst
- `inOrderTraversal()`: Left-Root-Right - O(n)
- `preOrderTraversal()`: Root-Left-Right - O(n)
- `postOrderTraversal()`: Left-Right-Root - O(n)

**Time Complexity:**
- Average case: O(log n) - tree is balanced
- Worst case: O(n) - tree becomes unbalanced (linked list)

**Space Complexity:** O(n) for storing nodes, O(log n) to O(n) for recursion stack during operations

**Why a BST can become unbalanced:**
- When elements are inserted in sorted order (ascending or descending)
- The tree degenerates into a linked list
- Example: inserting 1, 2, 3, 4, 5 creates a right-skewed tree
- This destroys the O(log n) advantage

**Traversals:**
- **In-order:** Produces sorted output
- **Pre-order:** Useful for copying tree structure
- **Post-order:** Useful for deleting tree (children before parent)

---

## Part E - Graphs

**Implementation:** Graph using adjacency matrix representation.

**Real-world Application:** Transport network with cities as vertices and roads as edges.

### 1. Depth-First Search (DFS)

**Implementation:** Recursive DFS.

**Algorithm:**
- Start at a vertex
- Mark as visited
- Recursively visit all unvisited adjacent vertices
- Uses call stack implicitly

**Time Complexity:** O(V + E) where V = vertices, E = edges  
**Space Complexity:** O(V) for visited array and recursion stack

### 2. Breadth-First Search (BFS)

**Implementation:** BFS using a queue.

**Algorithm:**
- Start at a vertex, mark as visited
- Add to queue
- While queue not empty:
  - Dequeue vertex
  - Add all unvisited adjacent vertices to queue
  - Mark them as visited

**Time Complexity:** O(V + E)  
**Space Complexity:** O(V) for visited array and queue

### 3. Shortest Path (by Number of Edges)

**Implementation:** BFS-based shortest path finding.

**Algorithm:**
- Use BFS from start vertex
- Track parent of each vertex
- When target is found, backtrack using parent array
- Reconstruct path from start to target

**Time Complexity:** O(V + E)  
**Space Complexity:** O(V) for tracking parents and distances

**Note:** This finds the shortest path in terms of number of edges, not geographical distance. For weighted graphs, Dijkstra's algorithm would be needed.

**Transport Network Example:**
- 6 cities: Cape Town, Johannesburg, Durban, Port Elizabeth, Bloemfontein, Pretoria
- Roads connect cities (undirected edges)
- Demonstrates connectivity and shortest routes between cities

---

## Conclusion

This project successfully implements all required algorithms and data structures for the ADP470S Programming Assignment. Key learnings include:

1. **Recursive algorithms** provide elegant solutions but have stack overhead
2. **Sorting algorithms** vary significantly in performance:
   - Selection Sort: Simple but slow (O(n²))
   - Quick Sort: Fast on average (O(n log n))
   - Heap Sort: Consistent performance (O(n log n))
3. **Data structures** from scratch require careful implementation:
   - Linked Lists provide dynamic sizing
   - Stacks and Queues provide LIFO/FIFO behavior
   - BSTs provide efficient search when balanced
4. **Graphs** with adjacency matrix are suitable for dense graphs
5. **Time and space complexity** analysis is crucial for algorithm selection

All implementations are object-oriented, well-commented, and follow Java best practices suitable for Advanced Diploma level coursework.

---

**End of Documentation**
