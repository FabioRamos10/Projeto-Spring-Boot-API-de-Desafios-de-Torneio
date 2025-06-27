package com.we.tournament.backend.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RankingDTOTest {

    @Test
    void testRankingDTO() {
        RankingDTO dto = new RankingDTO(1L, "Lucas", 250);
        assertEquals(1L, dto.getPlayerId());
        assertEquals("Lucas", dto.getPlayerName());
        assertEquals(250, dto.getTotalScore());
    }
}
