package com.we.tournament.backend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiErrorDTOTest {

    @Test
    void testGettersSettersAndConstructor() {
        ApiErrorDTO dto = new ApiErrorDTO();
        dto.setError("ValidationError");
        dto.setMessage("Campo obrigatório ausente");

        assertEquals("ValidationError", dto.getError());
        assertEquals("Campo obrigatório ausente", dto.getMessage());
    }

    @Test
    void testAllArgsConstructor() {
        ApiErrorDTO dto = new ApiErrorDTO("AuthError", "Token inválido");

        assertEquals("AuthError", dto.getError());
        assertEquals("Token inválido", dto.getMessage());
    }
}
