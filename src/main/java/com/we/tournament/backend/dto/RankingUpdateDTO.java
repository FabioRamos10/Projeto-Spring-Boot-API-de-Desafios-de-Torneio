package com.we.tournament.backend.dto;

import java.util.Objects;

public class RankingUpdateDTO {

    private String playerId;
    private int newScore;

    public RankingUpdateDTO() {
    }

    public RankingUpdateDTO(String playerId, int newScore) {
        this.playerId = playerId;
        this.newScore = newScore;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getNewScore() {
        return newScore;
    }

    public void setNewScore(int newScore) {
        this.newScore = newScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RankingUpdateDTO that)) return false;
        return newScore == that.newScore &&
                Objects.equals(playerId, that.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, newScore);
    }

    @Override
    public String toString() {
        return "RankingUpdateDTO{" +
                "playerId='" + playerId + '\'' +
                ", newScore=" + newScore +
                '}';
    }
}
