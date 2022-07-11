package dev.ryanribeiro.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoublyLinkedListTest {
    @Test
    public void canInitializeWithZeroElements() {
        final DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
    }
}
