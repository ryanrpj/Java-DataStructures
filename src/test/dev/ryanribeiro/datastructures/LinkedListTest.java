package dev.ryanribeiro.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LinkedListTest {
    @Test
    public void canInitializeWithZeroElements() {
        final LinkedList<Integer> list = new LinkedList<>();

        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
    }

    @Test
    public void canInitializeWithMultipleElements() {
        final LinkedList<Integer> list = new LinkedList<>(1, 2, 3);

        assertEquals(3, list.size());
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    public void canAppendAnElement() {
        final LinkedList<Integer> list = new LinkedList<>(1);
        assertEquals(1, list.size());

        list.append(3);
        assertEquals(2, list.size());
        assertEquals("[1, 3]", list.toString());
    }

    @Test
    public void canPrependAnElement() {
        final LinkedList<Integer> list = new LinkedList<>(2, 3);
        assertEquals(2, list.size());

        list.prepend(1);
        assertEquals(3, list.size());
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    public void canRemoveTheLastElement() {
        final LinkedList<Integer> list = new LinkedList<>(1, 2);

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
        final LinkedList<Integer> list = new LinkedList<>(1);

        list.removeLast();
        list.removeLast();
        list.append(2);
        list.append(3);

        assertEquals(2, list.size());
        assertEquals("[2, 3]", list.toString());
    }

    @Test
    public void canPrependAnElementAfterRemovingLast() {
        final LinkedList<Integer> list = new LinkedList<>(1);

        list.removeLast();
        list.removeLast();
        list.prepend(3);
        list.prepend(2);

        assertEquals(2, list.size());
        assertEquals("[2, 3]", list.toString());
    }

    @Test
    public void canRemoveTheFirstElement() {
        final LinkedList<Integer> list = new LinkedList<>(1, 2);

        final int removedElement = list.removeFirst();
        assertEquals(1, removedElement);
        assertEquals(1, list.size());
        assertEquals("[2]", list.toString());

        list.removeFirst();
        assertNull(list.removeFirst());
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
    }

    @Test
    public void canAppendAnElementAfterRemovingFirst() {
        final LinkedList<Integer> list = new LinkedList<>(1);

        list.removeFirst();
        list.removeFirst();
        list.append(2);
        list.append(3);

        assertEquals(2, list.size());
        assertEquals("[2, 3]", list.toString());
    }

    @Test
    public void canPrependAnElementAfterRemovingFirst() {
        final LinkedList<Integer> list = new LinkedList<>(1);

        list.removeFirst();
        list.removeFirst();
        list.prepend(3);
        list.prepend(2);

        assertEquals(2, list.size());
        assertEquals("[2, 3]", list.toString());
    }

    @Test
    public void canPrintElementsToConsole() {
        final LinkedList<Integer> list = new LinkedList<>(1, 2, 3);

        assertEquals("[1, 2, 3]", list.toString());
    }
}
