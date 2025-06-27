package com.we.tournament.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.we.tournament.backend.dto.TournamentDTO;
import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.model.Tournament;
import com.we.tournament.backend.service.TournamentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(TournamentController.class)
class TournamentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TournamentService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Tournament tournament;
    private Player player;

    @BeforeEach
    void setUp() {
        player = Player.builder().id(1L).name("Jogador 1").build();
        tournament = Tournament.builder()
                .id(1L)
                .name("Torneio Teste")
                .date(LocalDate.now())
                .finished(false)
                .players(Set.of(player))
                .build();
    }

    @Test
    void createTournament() throws Exception {
        TournamentDTO dto = new TournamentDTO();
        dto.setName("Novo Torneio");
        dto.setDate(LocalDate.of(2024, 6, 1));

        Tournament created = Tournament.builder().id(2L).name(dto.getName()).date(dto.getDate()).finished(false).build();

        when(service.create(dto.getName(), dto.getDate())).thenReturn(created);

        mockMvc.perform(post("/tournaments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.name").value("Novo Torneio"));
    }

    @Test
    void addPlayer() throws Exception {
        when(service.addPlayer(1L, 1L)).thenReturn(tournament);

        mockMvc.perform(put("/tournaments/1/add/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.players[0].name").value("Jogador 1"));
    }

    @Test
    void removePlayer() throws Exception {
        when(service.removePlayer(1L, 1L)).thenReturn(tournament);

        mockMvc.perform(put("/tournaments/1/remove/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.players[0].name").value("Jogador 1"));
    }

    @Test
    void finishTournament() throws Exception {
        doNothing().when(service).finish(1L);

        mockMvc.perform(put("/tournaments/1/finish"))
                .andExpect(status().isOk());
    }

    @Test
    void listPlayers() throws Exception {
        when(service.listPlayers(1L)).thenReturn(List.of(player));

        mockMvc.perform(get("/tournaments/1/players"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Jogador 1"));
    }
}
