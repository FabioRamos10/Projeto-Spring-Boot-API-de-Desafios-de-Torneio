package com.we.tournament.backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleResponseDTOTest {

    @Test
    void testGettersSettersAndConstructor() {
        SimpleResponseDTO dto = new SimpleResponseDTO();
        dto.setMessage("Operação realizada com sucesso");
        dto.setCode(200);

        assertEquals("Operação realizada com sucesso", dto.getMessage());
        assertEquals(200, dto.getCode());
    }

    @Test
    void testAllArgsConstructorAndEquals() {
        SimpleResponseDTO dto1 = new SimpleResponseDTO("OK", 200);
        SimpleResponseDTO dto2 = new SimpleResponseDTO("OK", 200);
        SimpleResponseDTO dto3 = new SimpleResponseDTO("Erro", 400);

        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void testToString() {
        SimpleResponseDTO dto = new SimpleResponseDTO("Created", 201);
        String toString = dto.toString();

        assertTrue(toString.contains("Created"));
        assertTrue(toString.contains("201"));
    }
}
