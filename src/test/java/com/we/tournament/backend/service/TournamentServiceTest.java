package com.we.tournament.backend.service;

import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.model.Tournament;
import com.we.tournament.backend.repository.PlayerRepository;
import com.we.tournament.backend.repository.TournamentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TournamentServiceTest {

    private TournamentRepository tournamentRepository;
    private PlayerRepository playerRepository;
    private TournamentService tournamentService;

    @BeforeEach
    void setUp() {
        tournamentRepository = mock(TournamentRepository.class);
        playerRepository = mock(PlayerRepository.class);
        tournamentService = new TournamentService(tournamentRepository, playerRepository);
    }

    @Test
    void testCreateTournament() {
        Tournament tournament = Tournament.builder()
                .id(1L)
                .name("Desafio WE")
                .date(LocalDate.now())
                .finished(false)
                .build();

        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament);

        Tournament created = tournamentService.create("Desafio WE", LocalDate.now());

        assertNotNull(created);
        assertEquals("Desafio WE", created.getName());
        verify(tournamentRepository).save(any(Tournament.class));
    }

    @Test
    void testAddPlayer() {
        Tournament t = Tournament.builder().id(1L).name("T1").players(new HashSet<>()).build();
        Player p = Player.builder().id(10L).name("Alice").build();

        when(tournamentRepository.findById(1L)).thenReturn(Optional.of(t));
        when(playerRepository.findById(10L)).thenReturn(Optional.of(p));
        when(tournamentRepository.save(any())).thenReturn(t);

        Tournament updated = tournamentService.addPlayer(1L, 10L);

        assertTrue(updated.getPlayers().contains(p));
    }

    @Test
    void testRemovePlayer() {
        Player p = Player.builder().id(2L).name("Bob").build();
        Set<Player> players = new HashSet<>();
        players.add(p);
        Tournament t = Tournament.builder().id(2L).name("T2").players(players).build();

        when(tournamentRepository.findById(2L)).thenReturn(Optional.of(t));
        when(playerRepository.findById(2L)).thenReturn(Optional.of(p));
        when(tournamentRepository.save(any())).thenReturn(t);

        Tournament updated = tournamentService.removePlayer(2L, 2L);

        assertFalse(updated.getPlayers().contains(p));
    }

    @Test
    void testFinishTournament() {
        Tournament t = Tournament.builder().id(3L).name("T3").finished(false).build();

        when(tournamentRepository.findById(3L)).thenReturn(Optional.of(t));

        tournamentService.finish(3L);

        assertTrue(t.isFinished());
        verify(tournamentRepository).save(t);
    }

    @Test
    void testListPlayers() {
        Player p1 = Player.builder().id(1L).name("A").build();
        Player p2 = Player.builder().id(2L).name("B").build();

        Set<Player> players = new HashSet<>(Arrays.asList(p1, p2));
        Tournament t = Tournament.builder().id(4L).players(players).build();

        when(tournamentRepository.findById(4L)).thenReturn(Optional.of(t));

        List<Player> result = tournamentService.listPlayers(4L);

        assertEquals(2, result.size());
    }

    @Test
    void testGetById_NotFound() {
        when(tournamentRepository.findById(99L)).thenReturn(Optional.empty());

        Exception ex = assertThrows(RuntimeException.class, () -> tournamentService.getById(99L));
        assertEquals("Torneio não encontrado", ex.getMessage());
    }
}
