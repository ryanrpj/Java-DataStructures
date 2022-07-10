package dev.ryanribeiro.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {
    @Test
    public void canInitializeWithZeroElements() {
        final LinkedList<Integer> list = new LinkedList<>();

        assertEquals(list.size(), 0);
    }

    @Test
    public void canInitializeWithMultipleElements() {
        final LinkedList<Integer> list = new LinkedList<>(1, 2, 3);

        assertEquals(list.size(), 3);
    }

    @Test
    public void canAppendAnElement() {
        final LinkedList<Integer> list = new LinkedList<>();
        assertEquals(list.size(), 0);

        list.append(3);
        assertEquals(list.size(), 1);
    }

    @Test
    public void canRemoveTheLastElement() {
        final LinkedList<Integer> list = new LinkedList<>(1, 2, 3);

        final int removedElement = list.removeLast();

        assertEquals(removedElement, 3);
        assertEquals(list.size(), 2);
    }

    @Test
    public void canPrintElementsToConsole() {
        final LinkedList<Integer> list = new LinkedList<>(1, 2, 3);

        assertEquals(list.toString(), "[1, 2, 3]");
    }
}
