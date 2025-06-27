package com.we.tournament.backend.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeTest {

    @Test
    void testConstructorAndGettersSetters() {
        Challenge c = new Challenge();
        c.setId("c1");
        c.setTitulo("Desafio Top");
        c.setData(LocalDate.of(2025, 6, 14));
        c.setJogadorDesafianteId("jogador1");
        c.setJogadorDesafiadoId("jogador2");
        c.setStatus("PENDENTE");

        assertEquals("c1", c.getId());
        assertEquals("Desafio Top", c.getTitulo());
        assertEquals(LocalDate.of(2025, 6, 14), c.getData());
        assertEquals("jogador1", c.getJogadorDesafianteId());
        assertEquals("jogador2", c.getJogadorDesafiadoId());
        assertEquals("PENDENTE", c.getStatus());
    }

    @Test
    void testAllArgsConstructor() {
        LocalDate date = LocalDate.of(2025, 6, 14);
        Challenge c = new Challenge("c1", "Titulo", date, "jogador1", "jogador2", "CONCLUIDO");

        assertEquals("c1", c.getId());
        assertEquals("Titulo", c.getTitulo());
        assertEquals(date, c.getData());
        assertEquals("jogador1", c.getJogadorDesafianteId());
        assertEquals("jogador2", c.getJogadorDesafiadoId());
        assertEquals("CONCLUIDO", c.getStatus());
    }

    @Test
    void testEqualsAndHashCode() {
        Challenge c1 = new Challenge("c1", "Titulo", null, null, null, null);
        Challenge c2 = new Challenge("c1", "Titulo", LocalDate.now(), "x", "y", "PENDENTE");
        Challenge c3 = new Challenge("c2", "Titulo", null, null, null, null);
        Challenge c4 = new Challenge("c1", "OutroTitulo", null, null, null, null);

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());

        assertNotEquals(c1, c3);

        assertNotEquals(c1, c4);
    }

    @Test
    void testEqualsWithNullAndDifferentObject() {
        Challenge c1 = new Challenge("c1", "Titulo", null, null, null, null);

        assertNotEquals(null, c1);
        assertNotEquals("uma string", c1);
    }

    @Test
    void testToStringContainsFields() {
        LocalDate date = LocalDate.of(2025, 6, 14);
        Challenge c = new Challenge("c1", "Titulo", date, "j1", "j2", "PENDENTE");
        String str = c.toString();

        assertTrue(str.contains("c1"));
        assertTrue(str.contains("Titulo"));
        assertTrue(str.contains(date.toString()));
        assertTrue(str.contains("j1"));
        assertTrue(str.contains("j2"));
        assertTrue(str.contains("PENDENTE"));
    }
}
