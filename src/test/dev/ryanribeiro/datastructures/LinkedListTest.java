package dev.ryanribeiro.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {
    @Test
    public void canInitializeAnEmptyList() {
        final LinkedList<Integer> list = new LinkedList<>();

        assertEquals(list.size(), 0);
    }

    @Test
    public void canInitializeAListWithStartingElements() {
        final LinkedList<Integer> list = new LinkedList<>(1, 2, 3);

        assertEquals(list.size(), 3);
    }

    @Test
    public void canPrintTheElementsToConsole() {
        final LinkedList<Integer> list = new LinkedList<>(1, 2, 3);

        assertEquals(list.toString(), "[1, 2, 3]");
    }
}
