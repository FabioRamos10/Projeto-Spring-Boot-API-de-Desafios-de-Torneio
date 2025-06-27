package com.we.tournament.backend.service;

import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepo;

    public PlayerService(PlayerRepository playerRepo) {
        this.playerRepo = playerRepo;
    }

    public Player create(String name) {
        Player player = Player.builder().name(name).build();
        return playerRepo.save(player);
    }

    public Player getById(Long id) {
        return playerRepo.findById(id).orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
    }

    public List<Player> searchByName(String name) {
        return playerRepo.findByNameContainingIgnoreCase(name);
    }

    public Player update(Long id, String name) {
        Player player = getById(id);
        player.setName(name);
        return playerRepo.save(player);
    }

    public void delete(Long id) {
        playerRepo.deleteById(id);
    }
}
