package com.we.tournament.backend.exeception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChallengeAlreadyExistsExceptionTest {

    @Test
    void testMessageConstructor() {
        ChallengeAlreadyExistsException ex = new ChallengeAlreadyExistsException("Desafio já existe");
        assertEquals("Desafio já existe", ex.getMessage());
    }

    @Test
    void testMessageAndCauseConstructor() {
        Throwable cause = new RuntimeException("Erro interno");
        ChallengeAlreadyExistsException ex = new ChallengeAlreadyExistsException("Erro", cause);
        assertEquals("Erro", ex.getMessage());
        assertEquals(cause, ex.getCause());
    }

    @Test
    void testDefaultConstructor() {
        ChallengeAlreadyExistsException ex = new ChallengeAlreadyExistsException();
        assertNull(ex.getMessage());
    }
}