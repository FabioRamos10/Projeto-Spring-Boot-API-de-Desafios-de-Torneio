package com.we.tournament.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RankingDTO {
    private Long playerId;
    private String playerName;
    private int totalScore;
}
