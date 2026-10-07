package za.ac.cput.partC;

/**
 * Circular array-based Queue implementation from scratch.
 * Operations: enqueue, dequeue, peek.
 */
public class Queue {

    private int[] array;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    /**
     * Adds an element to the rear of the queue.
     *
     * @throws IllegalStateException if queue is full
     */
    public void enqueue(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity; // Circular increment
        array[rear] = data;
        size++;
    }

    /**
     * Removes and returns the element from the front of the queue.
     *
     * @return the front element
     * @throws IllegalStateException if queue is empty
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = array[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        return data;
    }

    /**
     * Returns the front element without removing it.
     *
     * @return the front element
     * @throws IllegalStateException if queue is empty
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return array[front];
    }

    /**
     * Checks if the queue is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the queue is full.
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Returns the current size of the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Displays the contents of the queue (from front to rear).
     */
    public void display() {
        System.out.print("Queue (front to rear): ");
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }

        int current = front;
        for (int i = 0; i < size; i++) {
            System.out.print(array[current]);
            if (i < size - 1) {
                System.out.print(" -> ");
            }
            current = (current + 1) % capacity;
        }
        System.out.println();
    }
}
