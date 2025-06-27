package com.we.tournament.backend.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateAndRetrievePlayer() throws Exception {
        // Cria jogador
        String playerJson = """
            {
              "name": "João da Integração"
            }
        """;

        String response = mockMvc.perform(post("/players")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(playerJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("João da Integração"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long playerId = objectMapper.readTree(response).get("id").asLong();

        mockMvc.perform(get("/players/" + playerId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("João da Integração"));
    }
}
