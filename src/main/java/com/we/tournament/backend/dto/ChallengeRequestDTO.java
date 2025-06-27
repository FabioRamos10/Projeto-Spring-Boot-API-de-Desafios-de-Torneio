package com.we.tournament.backend.dto;

import lombok.Data;

@Data
public class ChallengeRequestDTO {
    private String type;
    private String input;
    private Long playerId;
    private Long tournamentId;
}
