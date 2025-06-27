package com.we.tournament.backend.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TournamentTest {

    @Test
    void testTournamentBuilderAndAccessors() {
        Player player = Player.builder().id(1L).name("Maria").build();
        Tournament t = Tournament.builder()
                .id(10L)
                .name("Spring Cup")
                .date(LocalDate.of(2025, 6, 1))
                .finished(false)
                .players(Set.of(player))
                .build();

        assertEquals("Spring Cup", t.getName());
        assertFalse(t.isFinished());
        assertEquals(1, t.getPlayers().size());
    }

    @Test
    void testTournamentToString() {
        Tournament t = new Tournament();
        t.setName("Copa");
        assertTrue(t.toString().contains("Copa"));
    }
}
