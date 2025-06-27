package com.we.tournament.backend.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeDTOTest {

    @Test
    void testGettersAndSetters() {
        ChallengeDTO dto = new ChallengeDTO();

        dto.setId("abc123");
        dto.setTitulo("Desafio Legal");
        dto.setData(LocalDate.of(2025, 6, 15));
        dto.setJogadorDesafianteId("jogador1");
        dto.setJogadorDesafiadoId("jogador2");
        dto.setStatus("PENDENTE");

        assertEquals("abc123", dto.getId());
        assertEquals("Desafio Legal", dto.getTitulo());
        assertEquals(LocalDate.of(2025, 6, 15), dto.getData());
        assertEquals("jogador1", dto.getJogadorDesafianteId());
        assertEquals("jogador2", dto.getJogadorDesafiadoId());
        assertEquals("PENDENTE", dto.getStatus());
    }
}
