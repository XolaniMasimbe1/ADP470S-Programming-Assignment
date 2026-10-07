package za.ac.cput.partC;

/**
 * Singly Linked List implementation from scratch.
 * Operations: insert, delete, search.
 */
public class SinglyLinkedList {

    /**
     * Node class for the linked list.
     */
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Inserts a new node at the beginning of the list.
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Inserts a new node at the end of the list.
     */
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Deletes the first occurrence of the specified data.
     *
     * @return true if deleted, false if not found
     */
    public boolean delete(int data) {
        if (head == null) {
            return false;
        }

        // If head contains the data
        if (head.data == data) {
            head = head.next;
            size--;
            return true;
        }

        // Search for the node to delete
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false; // Data not found
    }

    /**
     * Searches for a value in the list.
     *
     * @return true if found, false otherwise
     */
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Returns the size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Displays the contents of the list.
     */
    public void display() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
