package dev.ryanribeiro.datastructures;

final class Node<T> {
    private final T value;
    Node<T> next;

    Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

public class LinkedList<T> {
    private Node<T> head, tail;
    private int length = 0;

    public LinkedList() {}

    @SafeVarargs
    public LinkedList(T ...initialElements) {
        for (T element : initialElements) {
            this.append(element);
        }
    }

    /**
     * Gets the current amount of elements within the list.
     * @return Amount of elements.
     */
    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list.
     * @param element Element to be added.
     */
    public void append(T element) {
        final Node<T> newNode = new Node<>(element);

        if (tail != null) {
            tail.next = newNode;
            tail = newNode;
        } else {
            head = tail = newNode;
        }

        length++;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("[");

        Node<T> currentNode = head;

        while (currentNode != null) {
            sb.append(currentNode);

            if (currentNode.next != null)
                sb.append(", ");

            currentNode = currentNode.next;
        }

        sb.append("]");

        return sb.toString();
    }
}
