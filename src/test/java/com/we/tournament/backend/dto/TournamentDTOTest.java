package com.we.tournament.backend.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TournamentDTOTest {

    @Test
    void testTournamentDTO() {
        TournamentDTO dto = new TournamentDTO();
        dto.setId(5L);
        dto.setName("Inverno Cup");
        dto.setDate(LocalDate.of(2025, 7, 1));
        dto.setFinished(true);
        dto.setPlayerIds(Set.of(1L, 2L));

        assertEquals(5L, dto.getId());
        assertTrue(dto.isFinished());
        assertEquals(2, dto.getPlayerIds().size());
    }
}
