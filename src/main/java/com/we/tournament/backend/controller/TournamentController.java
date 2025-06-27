package com.we.tournament.backend.controller;

import com.we.tournament.backend.dto.TournamentDTO;
import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.model.Tournament;
import com.we.tournament.backend.service.TournamentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    private final TournamentService service;

    public TournamentController(TournamentService service) {
        this.service = service;
    }

    @PostMapping
    public Tournament create(@RequestBody TournamentDTO dto) {
        return service.create(dto.getName(), dto.getDate());
    }

    @PutMapping("/{id}/add/{playerId}")
    public Tournament addPlayer(@PathVariable Long id, @PathVariable Long playerId) {
        return service.addPlayer(id, playerId);
    }

    @PutMapping("/{id}/remove/{playerId}")
    public Tournament removePlayer(@PathVariable Long id, @PathVariable Long playerId) {
        return service.removePlayer(id, playerId);
    }

    @PutMapping("/{id}/finish")
    public void finish(@PathVariable Long id) {
        service.finish(id);
    }

    @GetMapping("/{id}/players")
    public List<Player> listPlayers(@PathVariable Long id) {
        return service.listPlayers(id);
    }
}
