package com.we.tournament.backend.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlayerGettersSettersAndBuilder() {
        Player player = Player.builder()
                .id(1L)
                .name("Alice")
                .build();

        assertEquals(1L, player.getId());
        assertEquals("Alice", player.getName());

        player.setName("Bob");
        assertEquals("Bob", player.getName());
    }

    @Test
    void testPlayerEqualsAndHashCode() {
        Player p1 = new Player(1L, "John");
        Player p2 = new Player(1L, "John");
        Player p3 = new Player(2L, "Doe");

        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testPlayerToString() {
        Player p = new Player(1L, "Test");
        assertTrue(p.toString().contains("Test"));
    }
}
