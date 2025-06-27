package com.we.tournament.backend.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChallengeTypeTest {

    @Test
    void testEnumValues() {
        assertEquals(3, ChallengeType.values().length);
        assertEquals(ChallengeType.FIBONACCI, ChallengeType.valueOf("FIBONACCI"));
    }

    @Test
    void testIsValidReturnsTrue() {
        assertTrue(ChallengeType.isValid("fibonacci"));
        assertTrue(ChallengeType.isValid("PALINDROME"));
    }

    @Test
    void testIsValidReturnsFalse() {
        assertFalse(ChallengeType.isValid("unknown"));
    }
}
