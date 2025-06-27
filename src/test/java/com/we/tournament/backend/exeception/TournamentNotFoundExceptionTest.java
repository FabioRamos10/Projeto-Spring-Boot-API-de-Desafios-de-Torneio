package com.we.tournament.backend.exeception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TournamentNotFoundExceptionTest {

    @Test
    void testMessageConstructor() {
        TournamentNotFoundException ex = new TournamentNotFoundException("Torneio não encontrado");
        assertEquals("Torneio não encontrado", ex.getMessage());
    }

    @Test
    void testDefaultConstructor() {
        TournamentNotFoundException ex = new TournamentNotFoundException();
        assertNull(ex.getMessage());
    }
}