package com.we.tournament.backend.service;

import com.we.tournament.backend.dto.RankingDTO;
import com.we.tournament.backend.model.ChallengeScore;
import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RankingService {

    private final ChallengeScoreService scoreService;
    private final PlayerRepository playerRepo;

    public RankingService(ChallengeScoreService scoreService, PlayerRepository playerRepo) {
        this.scoreService = scoreService;
        this.playerRepo = playerRepo;
    }

    public List<RankingDTO> globalRanking() {
        Map<Long, Integer> scoreMap = new HashMap<>();

        for (Player p : playerRepo.findAll()) {
            int total = scoreService.getByPlayer(p.getId()).stream()
                    .mapToInt(ChallengeScore::getScore)
                    .sum();
            scoreMap.put(p.getId(), total);
        }

        return scoreMap.entrySet().stream()
                .map(e -> new RankingDTO(e.getKey(), playerRepo.findById(e.getKey()).get().getName(), e.getValue()))
                .sorted(Comparator.comparingInt(RankingDTO::getTotalScore).reversed())
                .collect(Collectors.toList());
    }

    public List<RankingDTO> tournamentRanking(Long tournamentId) {
        Map<Long, Integer> scoreMap = new HashMap<>();

        for (ChallengeScore cs : scoreService.getByTournament(tournamentId)) {
            scoreMap.merge(cs.getPlayer().getId(), cs.getScore(), Integer::sum);
        }

        return scoreMap.entrySet().stream()
                .map(e -> new RankingDTO(e.getKey(), playerRepo.findById(e.getKey()).get().getName(), e.getValue()))
                .sorted(Comparator.comparingInt(RankingDTO::getTotalScore).reversed())
                .collect(Collectors.toList());
    }
}
