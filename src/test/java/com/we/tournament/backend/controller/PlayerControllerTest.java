package com.we.tournament.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.we.tournament.backend.dto.PlayerDTO;
import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlayerController.class)
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreatePlayer() throws Exception {
        PlayerDTO dto = new PlayerDTO();
        dto.setName("Alice");

        Player created = Player.builder().id(1L).name("Alice").build();
        Mockito.when(playerService.create("Alice")).thenReturn(created);

        mockMvc.perform(post("/players")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Alice"));
    }

    @Test
    void testGetPlayerById() throws Exception {
        Player player = Player.builder().id(2L).name("Bob").build();
        Mockito.when(playerService.getById(2L)).thenReturn(player);

        mockMvc.perform(get("/players/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.name").value("Bob"));
    }

    @Test
    void testSearchByName() throws Exception {
        List<Player> players = List.of(
                Player.builder().id(3L).name("Charlie").build()
        );
        Mockito.when(playerService.searchByName("Char")).thenReturn(players);

        mockMvc.perform(get("/players/search")
                        .param("name", "Char"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Charlie"));
    }

    @Test
    void testUpdatePlayer() throws Exception {
        PlayerDTO dto = new PlayerDTO();
        dto.setName("Updated Name");

        Player updated = Player.builder().id(4L).name("Updated Name").build();
        Mockito.when(playerService.update(eq(4L), eq("Updated Name"))).thenReturn(updated);

        mockMvc.perform(put("/players/4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(4L))
                .andExpect(jsonPath("$.name").value("Updated Name"));
    }

    @Test
    void testDeletePlayer() throws Exception {
        mockMvc.perform(delete("/players/5"))
                .andExpect(status().isOk());

        Mockito.verify(playerService).delete(5L);
    }
}
