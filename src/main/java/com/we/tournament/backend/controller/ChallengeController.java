package com.we.tournament.backend.controller;

import com.we.tournament.backend.challenge.ChallengeService;
import com.we.tournament.backend.dto.ChallengeRequestDTO;
import com.we.tournament.backend.dto.ChallengeResultDTO;
import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.model.Tournament;
import com.we.tournament.backend.service.PlayerService;
import com.we.tournament.backend.service.TournamentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;
    private final PlayerService playerService;
    private final TournamentService tournamentService;

    public ChallengeController(ChallengeService challengeService, PlayerService playerService, TournamentService tournamentService) {
        this.challengeService = challengeService;
        this.playerService = playerService;
        this.tournamentService = tournamentService;
    }

    @PostMapping("/execute")
    public ChallengeResultDTO execute(@RequestBody ChallengeRequestDTO dto) {
        Player player = playerService.getById(dto.getPlayerId());
        Tournament tournament = tournamentService.getById(dto.getTournamentId());
        String resultAndScore = challengeService.execute(dto.getType(), dto.getInput(), player, tournament);
        String[] parts = resultAndScore.split("\\|");
        return new ChallengeResultDTO(parts[0], Integer.parseInt(parts[1]));
    }
}
