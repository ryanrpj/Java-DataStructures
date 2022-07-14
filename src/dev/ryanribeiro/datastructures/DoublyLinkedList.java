package dev.ryanribeiro.datastructures;

final class DoublyLinkedNode<T> {
    private T value;
    DoublyLinkedNode<T> previous, next;

    DoublyLinkedNode(T value) {
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
        DoublyLinkedNode<T> nodeAtIndex = getNodeAtIndex(index);

        if (nodeAtIndex == null) return null;

        return nodeAtIndex.value();
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
        } else if (index == length) {
            append(element);
        } else {
            DoublyLinkedNode<T> currentNodeAtIndex = getNodeAtIndex(index);

            if (currentNodeAtIndex == null) return false;

            DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(element);
            DoublyLinkedNode<T> currentNodeAtPreviousIndex = currentNodeAtIndex.previous;

            newNode.next = currentNodeAtIndex;
            newNode.previous = currentNodeAtPreviousIndex;

            currentNodeAtIndex.previous = newNode;
            currentNodeAtPreviousIndex.next = newNode;

            length++;
        }

        return true;
    }

    /**
     * Removes the element at the specified index and returns it.
     *
     * @param index Index of the element to be removed.
     * @return The removed element.
     */
    public T remove(int index) {
        T removedElement;

        if (index == 0) {
            removedElement = removeFirst();
        } else if (index == length - 1) {
            removedElement = removeLast();
        } else {
            DoublyLinkedNode<T> nodeToBeRemoved = getNodeAtIndex(index);

            if (nodeToBeRemoved == null) return null;

            DoublyLinkedNode<T> previousNodeAtIndex = nodeToBeRemoved.previous;
            DoublyLinkedNode<T> nextNodeAtIndex = nodeToBeRemoved.next;

            nodeToBeRemoved.next = nodeToBeRemoved.previous = null;

            previousNodeAtIndex.next = nextNodeAtIndex;
            nextNodeAtIndex.previous = previousNodeAtIndex;

            removedElement = nodeToBeRemoved.value();

            length--;
        }

        return removedElement;
    }

    /**
     * Replace the element at the specified index and returns it.
     *
     * @param index      Index of the element to be replaced.
     * @param newElement The new element to replace.
     * @return The element that was replaced.
     */
    public T replace(int index, T newElement) {
        final DoublyLinkedNode<T> nodeToReplaceValue = getNodeAtIndex(index);

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
        return removedNode.value();
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
        return removedNode.value();
    }

    /**
     * Reverse the order of the elements of the list.
     * The last element becomes the first, and the first element becomes the last.
     */
    public void reverse() {
        if (length == 0 || length == 1) return;

        DoublyLinkedNode<T> temporary = head;

        head = tail;
        tail = temporary;

        DoublyLinkedNode<T> currentNode;

        while (temporary != null) {
            currentNode = temporary.previous;
            temporary.previous = temporary.next;
            temporary.next = currentNode;
            temporary = temporary.previous;
        }
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

    private DoublyLinkedNode<T> getNodeAtIndex(int index) {
        if (invalidIndex(index)) return null;

        DoublyLinkedNode<T> nodeAtIndex;

        if (index == 0) return head;
        if (index == length - 1) return tail;

        if (index < length / 2) {
            nodeAtIndex = getNodeAtIndexIteratingFromHead(index);
        } else {
            nodeAtIndex = getNodeAtIndexIteratingFromTail(index);
        }

        return nodeAtIndex;
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

    private boolean invalidIndex(int index) {
        return index < 0 || index > length - 1;
    }
}
