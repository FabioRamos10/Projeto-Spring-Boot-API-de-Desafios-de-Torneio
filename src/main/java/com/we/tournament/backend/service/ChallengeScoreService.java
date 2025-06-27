package com.we.tournament.backend.service;

import com.we.tournament.backend.model.ChallengeScore;
import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.model.Tournament;
import com.we.tournament.backend.repository.ChallengeScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeScoreService {

    private final ChallengeScoreRepository scoreRepo;

    public ChallengeScoreService(ChallengeScoreRepository scoreRepo) {
        this.scoreRepo = scoreRepo;
    }

    public ChallengeScore register(Player player, Tournament tournament, String type, int score) {
        ChallengeScore cs = ChallengeScore.builder()
                .player(player)
                .tournament(tournament)
                .challengeType(type)
                .score(score)
                .build();

        return scoreRepo.save(cs);
    }

    public List<ChallengeScore> getByTournament(Long tournamentId) {
        return scoreRepo.findByTournamentId(tournamentId);
    }

    public List<ChallengeScore> getByPlayer(Long playerId) {
        return scoreRepo.findByPlayerId(playerId);
    }
}
