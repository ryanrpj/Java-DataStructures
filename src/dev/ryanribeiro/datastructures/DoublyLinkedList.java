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

    /**
     * Gets the current amount of elements within the list.
     *
     * @return Amount of elements.
     */
    public int size() {
        return this.length;
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
