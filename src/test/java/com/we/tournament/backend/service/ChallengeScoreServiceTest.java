package com.we.tournament.backend.service;

import com.we.tournament.backend.model.ChallengeScore;
import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.model.Tournament;
import com.we.tournament.backend.repository.ChallengeScoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ChallengeScoreServiceTest {

    private ChallengeScoreService scoreService;
    private ChallengeScoreRepository scoreRepo;

    private Player player;
    private Tournament tournament;

    @BeforeEach
    void setup() {
        scoreRepo = mock(ChallengeScoreRepository.class);
        scoreService = new ChallengeScoreService(scoreRepo);

        player = Player.builder().id(1L).name("Alice").build();
        tournament = Tournament.builder().id(2L).name("Spring Cup").build();
    }

    @Test
    void testRegister() {
        ChallengeScore mockScore = ChallengeScore.builder()
                .id(1L)
                .player(player)
                .tournament(tournament)
                .challengeType("fibonacci")
                .score(10)
                .build();

        when(scoreRepo.save(any())).thenReturn(mockScore);

        ChallengeScore result = scoreService.register(player, tournament, "fibonacci", 10);

        assertNotNull(result);
        assertEquals("fibonacci", result.getChallengeType());
        assertEquals(10, result.getScore());
        assertEquals(player, result.getPlayer());
        assertEquals(tournament, result.getTournament());

        verify(scoreRepo).save(any(ChallengeScore.class));
    }

    @Test
    void testGetByTournament() {
        List<ChallengeScore> mockList = List.of(
                ChallengeScore.builder().id(1L).tournament(tournament).build()
        );

        when(scoreRepo.findByTournamentId(2L)).thenReturn(mockList);

        List<ChallengeScore> result = scoreService.getByTournament(2L);

        assertEquals(1, result.size());
        assertEquals(2L, result.get(0).getTournament().getId());
        verify(scoreRepo).findByTournamentId(2L);
    }

    @Test
    void testGetByPlayer() {
        List<ChallengeScore> mockList = List.of(
                ChallengeScore.builder().id(1L).player(player).build()
        );

        when(scoreRepo.findByPlayerId(1L)).thenReturn(mockList);

        List<ChallengeScore> result = scoreService.getByPlayer(1L);

        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getPlayer().getId());
        verify(scoreRepo).findByPlayerId(1L);
    }
}
