package com.we.tournament.backend.exeception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerNotFoundExceptionTest {

    @Test
    void testMessageConstructor() {
        String msg = "Player not found";
        PlayerNotFoundException ex = new PlayerNotFoundException(msg);
        assertEquals(msg, ex.getMessage());
    }

    @Test
    void testDefaultConstructor() {
        PlayerNotFoundException ex = new PlayerNotFoundException();
        assertNull(ex.getMessage());
    }
}