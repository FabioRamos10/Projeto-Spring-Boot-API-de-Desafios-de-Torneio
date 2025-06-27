package com.we.tournament.backend.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TournamentSummaryDTOTest {

    @Test
    void testGettersSetters() {
        TournamentSummaryDTO dto = new TournamentSummaryDTO();
        dto.setId(1L);
        dto.setName("Outono Cup");
        dto.setDate(LocalDate.of(2025, 10, 1));
        dto.setFinished(true);

        assertEquals(1L, dto.getId());
        assertEquals("Outono Cup", dto.getName());
        assertEquals(LocalDate.of(2025, 10, 1), dto.getDate());
        assertTrue(dto.isFinished());
    }

    @Test
    void testAllArgsConstructor() {
        TournamentSummaryDTO dto = new TournamentSummaryDTO(2L, "Primavera Cup", LocalDate.of(2025, 9, 1), false);

        assertEquals(2L, dto.getId());
        assertEquals("Primavera Cup", dto.getName());
        assertEquals(LocalDate.of(2025, 9, 1), dto.getDate());
        assertFalse(dto.isFinished());
    }
}
