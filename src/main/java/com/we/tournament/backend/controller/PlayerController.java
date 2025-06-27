package com.we.tournament.backend.controller;

import com.we.tournament.backend.dto.PlayerDTO;
import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public Player create(@RequestBody PlayerDTO dto) {
        return playerService.create(dto.getName());
    }

    @GetMapping("/{id}")
    public Player getById(@PathVariable Long id) {
        return playerService.getById(id);
    }

    @GetMapping("/search")
    public List<Player> search(@RequestParam String name) {
        return playerService.searchByName(name);
    }

    @PutMapping("/{id}")
    public Player update(@PathVariable Long id, @RequestBody PlayerDTO dto) {
        return playerService.update(id, dto.getName());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerService.delete(id);
    }
}
