package dev.ryanribeiro.datastructures;

final class DoublyLinkedNode<T> {
    final T value;
    DoublyLinkedNode<T> previous, next;

    DoublyLinkedNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

public class DoublyLinkedList<T> {
    private int length = 0;
    private DoublyLinkedNode<T> head = null, tail = null;

    public DoublyLinkedList() {
    }

    @SafeVarargs
    public DoublyLinkedList(T... initialElements) {
        for (T element : initialElements)
            append(element);
    }

    /**
     * Gets the current amount of elements within the list.
     *
     * @return Amount of elements.
     */
    public int size() {
        return this.length;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element Element to be added.
     */
    public void append(T element) {
        final DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(element);

        if (length == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        length++;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("[");

        DoublyLinkedNode<T> currentNode = head;

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
