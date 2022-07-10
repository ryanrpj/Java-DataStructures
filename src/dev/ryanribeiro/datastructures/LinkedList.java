package dev.ryanribeiro.datastructures;

final class Node<T> {
    private T value;
    Node<T> next;

    Node(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

    public void setValue(T newValue) {
        value = newValue;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

public class LinkedList<T> {
    private Node<T> head, tail;
    private int length = 0;

    public LinkedList() {
    }

    @SafeVarargs
    public LinkedList(T... initialElements) {
        for (T element : initialElements) {
            this.append(element);
        }
    }

    /**
     * Gets the current amount of elements within the list.
     *
     * @return Amount of elements.
     */
    public int size() {
        return length;
    }

    /**
     * Gets the element at the specified index.
     *
     * @param index Index of the element to be retrieved.
     * @return The element at the specified index.
     */
    public T get(int index) {
        Node<T> retrievedNode = getNode(index);

        if (retrievedNode != null)
            return retrievedNode.value();

        return null;
    }

    /**
     * Inserts an element at the specified index.
     *
     * @param index   Index to insert the element.
     * @param element Element to be inserted.
     * @return True of false indicating whether the element was inserted or not.
     */
    public boolean insert(int index, T element) {
        if (index == 0) {
            prepend(element);
            return true;
        }

        if (index == length) {
            append(element);
            return true;
        }

        Node<T> nodeToBeInserted = new Node<>(element);
        Node<T> currentNodeBeforeSpecifiedIndex = getNode(index - 1);

        if (currentNodeBeforeSpecifiedIndex == null)
            return false;

        Node<T> currentNodeAtSpecifiedIndex = currentNodeBeforeSpecifiedIndex.next;

        currentNodeBeforeSpecifiedIndex.next = nodeToBeInserted;
        nodeToBeInserted.next = currentNodeAtSpecifiedIndex;

        length++;
        return true;
    }

    /**
     * Removes the element at the specified index and returns it.
     *
     * @param index Index of the element to be removed.
     * @return The removed element.
     */
    public T remove(int index) {
        if (index == 0)
            return removeFirst();

        if (index == length - 1)
            return removeLast();

        Node<T> currentNodeBeforeSpecifiedIndex = getNode(index - 1);

        if (currentNodeBeforeSpecifiedIndex == null) return null;

        Node<T> nodeToBeRemoved = currentNodeBeforeSpecifiedIndex.next;

        currentNodeBeforeSpecifiedIndex.next = nodeToBeRemoved.next;

        length--;

        if (length == 0)
            head = tail = null;

        return nodeToBeRemoved.value();
    }

    /**
     * Replace the element at the specified index and returns it.
     *
     * @param index      Index of the element to be replaced.
     * @param newElement The new element to replace.
     * @return The element that was replaced.
     */
    public T replace(int index, T newElement) {
        final Node<T> nodeToReplaceValue = getNode(index);

        if (nodeToReplaceValue == null) return null;

        final T oldValue = nodeToReplaceValue.value();

        nodeToReplaceValue.setValue(newElement);

        return oldValue;
    }

    /**
     * Adds an element to the end of the list.
     *
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

    /**
     * Adds an element to the beginning of the list.
     *
     * @param element Element to be added.
     */
    public void prepend(T element) {
        final Node<T> newNode = new Node<>(element);

        if (length == 0) {
            head = tail = newNode;
        } else {
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

        Node<T> penultimateNode = head, ultimateNode = head;

        while (ultimateNode.next != null) {
            penultimateNode = ultimateNode;
            ultimateNode = ultimateNode.next;
        }

        tail = penultimateNode;
        tail.next = null;
        length--;

        if (length == 0)
            head = tail = null;

        return ultimateNode.value();
    }

    /**
     * Removes the first element from the list and returns it.
     *
     * @return The removed element.
     */
    public T removeFirst() {
        if (length == 0) return null;

        Node<T> removedNode = head;

        if (length == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }

        length--;
        return removedNode.value();
    }

    /**
     * Reverse the order of the elements of the list.
     * The last element becomes the first, and the first element becomes the last.
     */
    public void reverse() {
        if (length < 2) return;

        Node<T> temporaryNode = head;

        head = tail;
        tail = temporaryNode;

        Node<T> nextNode, previousNode = null;

        for (int i = 0; i < length; i++) {
            nextNode = temporaryNode.next;
            temporaryNode.next = previousNode;
            previousNode = temporaryNode;
            temporaryNode = nextNode;
        }
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

    private boolean invalidIndex(int index) {
        return index < 0 || index > length - 1;
    }

    private Node<T> getNode(int index) {
        if (invalidIndex(index)) return null;

        int currentIndex = 0;
        Node<T> retrievedNode = head;

        while (currentIndex != index) {
            retrievedNode = retrievedNode.next;
            currentIndex++;
        }

        return retrievedNode;
    }
}
