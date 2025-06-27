package com.we.tournament.backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeRequestDTOTest {

    @Test
    void testGettersAndSetters() {
        ChallengeRequestDTO dto = new ChallengeRequestDTO();
        dto.setType("fibonacci");
        dto.setInput("5");
        dto.setPlayerId(1L);
        dto.setTournamentId(2L);

        assertEquals("fibonacci", dto.getType());
        assertEquals("5", dto.getInput());
        assertEquals(1L, dto.getPlayerId());
        assertEquals(2L, dto.getTournamentId());
    }
}
