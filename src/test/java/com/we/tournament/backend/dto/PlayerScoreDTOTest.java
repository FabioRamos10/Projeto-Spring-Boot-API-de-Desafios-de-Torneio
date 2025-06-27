package com.we.tournament.backend.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerScoreDTOTest {

    @Test
    void testGettersSetters() {
        PlayerScoreDTO dto = new PlayerScoreDTO();
        dto.setPlayerId(1L);
        dto.setPlayerName("Lucas");
        dto.setScore(120);

        assertEquals(1L, dto.getPlayerId());
        assertEquals("Lucas", dto.getPlayerName());
        assertEquals(120, dto.getScore());
    }

    @Test
    void testAllArgsConstructor() {
        PlayerScoreDTO dto = new PlayerScoreDTO(2L, "João", 90);

        assertEquals(2L, dto.getPlayerId());
        assertEquals("João", dto.getPlayerName());
        assertEquals(90, dto.getScore());
    }
}
