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
     * Gets the element at the specified index.
     *
     * @param index Index of the element to be retrieved.
     * @return The element at the specified index.
     */
    public T get(int index) {
        if (invalidIndex(index)) return null;

        DoublyLinkedNode<T> nodeAtIndex;

        if (index == 0) return head.value;
        if (index == length - 1) return tail.value;

        if (index < length / 2) {
            nodeAtIndex = getNodeAtIndexIteratingFromHead(index);
        } else {
            nodeAtIndex = getNodeAtIndexIteratingFromTail(index);
        }

        return nodeAtIndex.value;
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

    /**
     * Adds an element to the beginning of the list.
     *
     * @param element Element to be added.
     */
    public void prepend(T element) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(element);

        if (length == 0) {
            head = tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        }

        length++;
    }

    /**
     * Removes the last element from the list and returns it.
     *
     * @return The removed element.
     */
    public T removeLast() {
        if (length == 0) return null;

        final DoublyLinkedNode<T> removedNode = tail;

        if (length == 1) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
            removedNode.previous = null;
        }

        length--;
        return removedNode.value;
    }

    /**
     * Removes the first element from the list and returns it.
     *
     * @return The removed element.
     */
    public T removeFirst() {
        if (length == 0) return null;

        DoublyLinkedNode<T> removedNode = head;

        if (length == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.previous = null;
            removedNode.next = null;
        }

        length--;
        return removedNode.value;
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

    private boolean invalidIndex(int index) {
        return index < 0 || index > length - 1;
    }

    private DoublyLinkedNode<T> getNodeAtIndexIteratingFromHead(int index) {
        DoublyLinkedNode<T> nodeAtIndex = head;

        for (int i = 0; i < index; i++) {
            nodeAtIndex = nodeAtIndex.next;
        }

        return nodeAtIndex;
    }

    private DoublyLinkedNode<T> getNodeAtIndexIteratingFromTail(int index) {
        DoublyLinkedNode<T> nodeAtIndex = tail;

        for (int i = length - 1; i > index; i--) {
            nodeAtIndex = nodeAtIndex.previous;
        }

        return nodeAtIndex;
    }
}
