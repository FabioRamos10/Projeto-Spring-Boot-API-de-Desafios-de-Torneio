package com.we.tournament.backend.repository;

import com.we.tournament.backend.model.ChallengeScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChallengeScoreRepository extends JpaRepository<ChallengeScore, Long> {
    List<ChallengeScore> findByTournamentId(Long tournamentId);
    List<ChallengeScore> findByPlayerId(Long playerId);
}
