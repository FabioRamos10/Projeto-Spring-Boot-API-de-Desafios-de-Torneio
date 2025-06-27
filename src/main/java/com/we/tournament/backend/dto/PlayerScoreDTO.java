package com.we.tournament.backend.dto;

public class PlayerScoreDTO {
    private Long playerId;
    private String playerName;
    private int score;

    public PlayerScoreDTO() {
    }

    public PlayerScoreDTO(Long playerId, String playerName, int score) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.score = score;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
