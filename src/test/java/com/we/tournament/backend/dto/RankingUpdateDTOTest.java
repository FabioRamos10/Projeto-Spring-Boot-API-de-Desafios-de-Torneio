package com.we.tournament.backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RankingUpdateDTOTest {

    @Test
    void testGettersAndSetters() {
        RankingUpdateDTO dto = new RankingUpdateDTO();
        dto.setPlayerId("player123");
        dto.setNewScore(1500);

        assertEquals("player123", dto.getPlayerId());
        assertEquals(1500, dto.getNewScore());
    }

    @Test
    void testAllArgsConstructor() {
        RankingUpdateDTO dto = new RankingUpdateDTO("player123", 1500);
        assertEquals("player123", dto.getPlayerId());
        assertEquals(1500, dto.getNewScore());
    }

    @Test
    void testEqualsAndHashCode() {
        RankingUpdateDTO dto1 = new RankingUpdateDTO("playerX", 1000);
        RankingUpdateDTO dto2 = new RankingUpdateDTO("playerX", 1000);
        RankingUpdateDTO dto3 = new RankingUpdateDTO("playerY", 1000);

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());

        assertNotEquals(dto1, dto3);
        assertNotEquals(dto1.hashCode(), dto3.hashCode());
    }

    @Test
    void testToString() {
        RankingUpdateDTO dto = new RankingUpdateDTO("playerZ", 999);
        String toString = dto.toString();

        assertTrue(toString.contains("playerZ"));
        assertTrue(toString.contains("999"));
        assertTrue(toString.contains("RankingUpdateDTO"));
    }
}
