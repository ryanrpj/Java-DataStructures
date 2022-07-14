package dev.ryanribeiro.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DoublyLinkedListTest {
    @Test
    public void canInitializeWithZeroElements() {
        final DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
    }

    @Test
    public void canInitializeWithMultipleElements() {
        final DoublyLinkedList<Integer> list = new DoublyLinkedList<>(1, 2, 3);

        assertEquals(3, list.size());
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    public void canAppendAnElement() {
        final DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.append(3);
        list.append(4);
        assertEquals(2, list.size());
        assertEquals("[3, 4]", list.toString());
    }

    @Test
    public void canRemoveTheLastElement() {
        final DoublyLinkedList<Integer> list = new DoublyLinkedList<>(1, 2);

        final int removedElement = list.removeLast();
        assertEquals(2, removedElement);
        assertEquals(1, list.size());
        assertEquals("[1]", list.toString());

        list.removeLast();
        assertNull(list.removeLast());
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
    }

    @Test
    public void canAppendAnElementAfterRemovingLast() {
        final DoublyLinkedList<Integer> list = new DoublyLinkedList<>(1);

        list.removeLast();
        list.removeLast();
        list.append(2);
        list.append(3);

        assertEquals(2, list.size());
        assertEquals("[2, 3]", list.toString());
    }
}
