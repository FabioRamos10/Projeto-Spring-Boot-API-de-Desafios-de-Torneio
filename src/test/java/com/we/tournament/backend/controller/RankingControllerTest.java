package com.we.tournament.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.we.tournament.backend.dto.RankingDTO;
import com.we.tournament.backend.service.RankingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RankingController.class)
class RankingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RankingService rankingService;

    private List<RankingDTO> mockRanking;

    @BeforeEach
    void setUp() {
        mockRanking = List.of(
                new RankingDTO(1L, "Alice", 30),
                new RankingDTO(2L, "Bob", 20)
        );
    }

    @Test
    void testGlobalRanking() throws Exception {
        when(rankingService.globalRanking()).thenReturn(mockRanking);

        mockMvc.perform(get("/ranking/global"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].playerId").value(1))
                .andExpect(jsonPath("$[0].playerName").value("Alice"))
                .andExpect(jsonPath("$[0].totalScore").value(30));
    }

    @Test
    void testTournamentRanking() throws Exception {
        when(rankingService.tournamentRanking(99L)).thenReturn(mockRanking);

        mockMvc.perform(get("/ranking/tournament/99"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[1].playerId").value(2))
                .andExpect(jsonPath("$[1].playerName").value("Bob"))
                .andExpect(jsonPath("$[1].totalScore").value(20));
    }
}
