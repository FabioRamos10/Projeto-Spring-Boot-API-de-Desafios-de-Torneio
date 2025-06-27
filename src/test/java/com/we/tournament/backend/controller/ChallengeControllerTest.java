package com.we.tournament.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.we.tournament.backend.challenge.ChallengeService;
import com.we.tournament.backend.dto.ChallengeRequestDTO;
import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.model.Tournament;
import com.we.tournament.backend.service.PlayerService;
import com.we.tournament.backend.service.TournamentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ChallengeController.class)
class ChallengeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChallengeService challengeService;

    @MockBean
    private PlayerService playerService;

    @MockBean
    private TournamentService tournamentService;

    @Autowired
    private ObjectMapper objectMapper;

    private final Player dummyPlayer = Player.builder().id(1L).name("Test Player").build();
    private final Tournament dummyTournament = Tournament.builder().id(1L).name("Test Tournament").build();

    @Test
    void testExecuteFibonacciChallenge() throws Exception {
        ChallengeRequestDTO request = new ChallengeRequestDTO();
        request.setType("fibonacci");
        request.setInput("5");
        request.setPlayerId(1L);
        request.setTournamentId(1L);

        Mockito.when(playerService.getById(1L)).thenReturn(dummyPlayer);
        Mockito.when(tournamentService.getById(1L)).thenReturn(dummyTournament);
        Mockito.when(challengeService.execute(eq("fibonacci"), eq("5"), any(), any()))
                .thenReturn("5|10");

        mockMvc.perform(post("/challenges/execute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("5"))
                .andExpect(jsonPath("$.score").value(10));
    }

    @Test
    void testExecutePalindromeChallenge() throws Exception {
        ChallengeRequestDTO request = new ChallengeRequestDTO();
        request.setType("palindrome");
        request.setInput("racecar");
        request.setPlayerId(1L);
        request.setTournamentId(1L);

        Mockito.when(playerService.getById(1L)).thenReturn(dummyPlayer);
        Mockito.when(tournamentService.getById(1L)).thenReturn(dummyTournament);
        Mockito.when(challengeService.execute(eq("palindrome"), eq("racecar"), any(), any()))
                .thenReturn("true|5");

        mockMvc.perform(post("/challenges/execute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("true"))
                .andExpect(jsonPath("$.score").value(5));
    }

    @Test
    void testExecuteSortingChallenge() throws Exception {
        ChallengeRequestDTO request = new ChallengeRequestDTO();
        request.setType("sorting");
        request.setInput("[5,3,1]");
        request.setPlayerId(1L);
        request.setTournamentId(1L);

        Mockito.when(playerService.getById(1L)).thenReturn(dummyPlayer);
        Mockito.when(tournamentService.getById(1L)).thenReturn(dummyTournament);
        Mockito.when(challengeService.execute(eq("sorting"), eq("[5,3,1]"), any(), any()))
                .thenReturn("1,3,5|7");

        mockMvc.perform(post("/challenges/execute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("1,3,5"))
                .andExpect(jsonPath("$.score").value(7));
    }

    @Test
    void testInvalidChallengeType() throws Exception {
        ChallengeRequestDTO request = new ChallengeRequestDTO();
        request.setType("invalid-type");
        request.setInput("123");
        request.setPlayerId(1L);
        request.setTournamentId(1L);

        Mockito.when(playerService.getById(1L)).thenReturn(dummyPlayer);
        Mockito.when(tournamentService.getById(1L)).thenReturn(dummyTournament);
        Mockito.when(challengeService.execute(eq("invalid-type"), eq("123"), any(), any()))
                .thenThrow(new IllegalArgumentException("Tipo de desafio inválido: invalid-type"));

        mockMvc.perform(post("/challenges/execute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Tipo de desafio inválido: invalid-type"));
    }
}
