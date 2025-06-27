package com.we.tournament.backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDTOTest {

    @Test
    void testPlayerDTO() {
        PlayerDTO dto = new PlayerDTO();
        dto.setId(1L);
        dto.setName("Carlos");

        assertEquals(1L, dto.getId());
        assertEquals("Carlos", dto.getName());
    }
}
