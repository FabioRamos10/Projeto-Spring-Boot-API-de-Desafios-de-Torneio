package com.we.tournament.backend.challenge;

import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.model.Tournament;
import com.we.tournament.backend.service.ChallengeScoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChallengeServiceTest {

    private ChallengeScoreService scoreService;
    private ChallengeService challengeService;
    private Player player;
    private Tournament tournament;

    @BeforeEach
    void setUp() {
        scoreService = mock(ChallengeScoreService.class);
        challengeService = new ChallengeService(scoreService);
        player = Player.builder().id(1L).name("Jogador").build();
        tournament = Tournament.builder().id(1L).name("Torneio").build();
    }

    @Test
    void testFibonacciChallenge() {
        String result = challengeService.execute("fibonacci", "7", player, tournament);
        assertTrue(result.startsWith("13|")); // 7º termo de Fibonacci = 13
        verify(scoreService).register(player, tournament, "fibonacci", 10);
    }

    @Test
    void testPalindromeChallenge_True() {
        String result = challengeService.execute("palindrome", "Ame a ema", player, tournament);
        assertEquals("true|5", result);
        verify(scoreService).register(player, tournament, "palindrome", 5);
    }

    @Test
    void testPalindromeChallenge_False() {
        String result = challengeService.execute("palindrome", "banana", player, tournament);
        assertEquals("false|0", result);
        verify(scoreService).register(player, tournament, "palindrome", 0);
    }

    @Test
    void testSortingChallenge() {
        String result = challengeService.execute("sorting", "[3,2,1]", player, tournament);
        assertEquals("1,2,3|7", result);
        verify(scoreService).register(player, tournament, "sorting", 7);
    }

    @Test
    void testInvalidChallengeType() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                challengeService.execute("xyz", "123", player, tournament));

        assertTrue(ex.getMessage().contains("Tipo de desafio inválido"));
        verify(scoreService, never()).register(any(), any(), any(), anyInt());
    }
}
