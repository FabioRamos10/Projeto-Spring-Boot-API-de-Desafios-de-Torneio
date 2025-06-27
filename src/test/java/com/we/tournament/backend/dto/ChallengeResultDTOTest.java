package com.we.tournament.backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeResultDTOTest {

    @Test
    void testGettersAndSetters() {
        ChallengeResultDTO dto = new ChallengeResultDTO();
        dto.setResult("8");
        dto.setScore(10);

        assertEquals("8", dto.getResult());
        assertEquals(10, dto.getScore());
    }

    @Test
    void testAllArgsConstructor() {
        ChallengeResultDTO dto = new ChallengeResultDTO("8", 10);
        assertEquals("8", dto.getResult());
        assertEquals(10, dto.getScore());
    }
}
