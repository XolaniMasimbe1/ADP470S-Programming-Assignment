package za.ac.cput.partC;

/**
 * Array-based Stack implementation from scratch.
 * Operations: push, pop, peek.
 */
public class Stack {

    private int[] array;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.top = -1; // Stack is empty when top is -1
    }

    /**
     * Pushes an element onto the stack.
     *
     * @throws IllegalStateException if stack is full
     */
    public void push(int data) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        array[++top] = data;
    }

    /**
     * Removes and returns the top element from the stack.
     *
     * @return the top element
     * @throws IllegalStateException if stack is empty
     */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top--];
    }

    /**
     * Returns the top element without removing it.
     *
     * @return the top element
     * @throws IllegalStateException if stack is empty
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top];
    }

    /**
     * Checks if the stack is empty.
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Checks if the stack is full.
     */
    public boolean isFull() {
        return top == capacity - 1;
    }

    /**
     * Returns the current size of the stack.
     */
    public int size() {
        return top + 1;
    }

    /**
     * Displays the contents of the stack (from top to bottom).
     */
    public void display() {
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(array[i]);
            if (i > 0) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    /**
     * Reverses a string using the stack.
     */
    public static String reverseString(String input) {
        Stack stack = new Stack(input.length());

        // Push all characters onto the stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Pop all characters to build the reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append((char) stack.pop());
        }

        return reversed.toString();
    }
}
