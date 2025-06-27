package com.we.tournament.backend.service;

import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerServiceTest {

    private PlayerRepository playerRepository;
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        playerRepository = mock(PlayerRepository.class);
        playerService = new PlayerService(playerRepository);
    }

    @Test
    void testCreatePlayer() {
        Player input = Player.builder().name("Ana").build();
        Player saved = Player.builder().id(1L).name("Ana").build();

        when(playerRepository.save(any(Player.class))).thenReturn(saved);

        Player result = playerService.create("Ana");

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Ana", result.getName());
        verify(playerRepository).save(any(Player.class));
    }

    @Test
    void testGetById_Success() {
        Player player = Player.builder().id(1L).name("João").build();
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player));

        Player result = playerService.getById(1L);

        assertEquals("João", result.getName());
        verify(playerRepository).findById(1L);
    }

    @Test
    void testGetById_NotFound() {
        when(playerRepository.findById(999L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> playerService.getById(999L));
        assertEquals("Jogador não encontrado", exception.getMessage());
    }

    @Test
    void testSearchByName() {
        Player p1 = Player.builder().id(1L).name("Leo").build();
        Player p2 = Player.builder().id(2L).name("Leonardo").build();

        when(playerRepository.findByNameContainingIgnoreCase("leo"))
                .thenReturn(Arrays.asList(p1, p2));

        var result = playerService.searchByName("leo");

        assertEquals(2, result.size());
        verify(playerRepository).findByNameContainingIgnoreCase("leo");
    }

    @Test
    void testUpdatePlayer() {
        Player existing = Player.builder().id(1L).name("Old Name").build();
        Player updated = Player.builder().id(1L).name("New Name").build();

        when(playerRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(playerRepository.save(any(Player.class))).thenReturn(updated);

        Player result = playerService.update(1L, "New Name");

        assertEquals("New Name", result.getName());
    }

    @Test
    void testDeletePlayer() {
        doNothing().when(playerRepository).deleteById(1L);
        playerService.delete(1L);
        verify(playerRepository).deleteById(1L);
    }
}
