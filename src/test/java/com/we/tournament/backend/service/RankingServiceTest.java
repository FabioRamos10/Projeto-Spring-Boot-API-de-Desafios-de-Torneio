package com.we.tournament.backend.service;

import com.we.tournament.backend.dto.RankingDTO;
import com.we.tournament.backend.model.ChallengeScore;
import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RankingServiceTest {

    private ChallengeScoreService challengeScoreService;
    private PlayerRepository playerRepository;
    private RankingService rankingService;

    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        challengeScoreService = mock(ChallengeScoreService.class);
        playerRepository = mock(PlayerRepository.class);
        rankingService = new RankingService(challengeScoreService, playerRepository);

        player1 = Player.builder().id(1L).name("Alice").build();
        player2 = Player.builder().id(2L).name("Bob").build();
    }

    @Test
    void testGlobalRanking() {
        when(playerRepository.findAll()).thenReturn(Arrays.asList(player1, player2));
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player1));
        when(playerRepository.findById(2L)).thenReturn(Optional.of(player2));

        List<ChallengeScore> scores1 = Arrays.asList(
                ChallengeScore.builder().score(10).player(player1).build(),
                ChallengeScore.builder().score(5).player(player1).build()
        );

        List<ChallengeScore> scores2 = List.of(
                ChallengeScore.builder().score(7).player(player2).build()
        );

        when(challengeScoreService.getByPlayer(1L)).thenReturn(scores1);
        when(challengeScoreService.getByPlayer(2L)).thenReturn(scores2);

        List<RankingDTO> ranking = rankingService.globalRanking();

        assertEquals(2, ranking.size());
        assertEquals("Alice", ranking.get(0).getPlayerName());
        assertEquals(15, ranking.get(0).getTotalScore());
        assertEquals("Bob", ranking.get(1).getPlayerName());
        assertEquals(7, ranking.get(1).getTotalScore());
    }

    @Test
    void testTournamentRanking() {
        List<ChallengeScore> scores = Arrays.asList(
                ChallengeScore.builder().score(8).player(player2).build(),
                ChallengeScore.builder().score(6).player(player1).build(),
                ChallengeScore.builder().score(4).player(player1).build()
        );

        when(challengeScoreService.getByTournament(100L)).thenReturn(scores);
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player1));
        when(playerRepository.findById(2L)).thenReturn(Optional.of(player2));

        List<RankingDTO> ranking = rankingService.tournamentRanking(100L);

        assertEquals(2, ranking.size());
        assertEquals("Alice", ranking.get(0).getPlayerName()); // 10 pontos
        assertEquals("Bob", ranking.get(1).getPlayerName());   // 8 pontos
    }
}
