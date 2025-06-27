package com.we.tournament.backend.service;

import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.model.Tournament;
import com.we.tournament.backend.repository.PlayerRepository;
import com.we.tournament.backend.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepo;
    private final PlayerRepository playerRepo;

    public TournamentService(TournamentRepository tournamentRepo, PlayerRepository playerRepo) {
        this.tournamentRepo = tournamentRepo;
        this.playerRepo = playerRepo;
    }

    public Tournament create(String name, LocalDate date) {
        Tournament t = Tournament.builder().name(name).date(date).finished(false).build();
        return tournamentRepo.save(t);
    }

    public Tournament getById(Long id) {
        return tournamentRepo.findById(id).orElseThrow(() -> new RuntimeException("Torneio não encontrado"));
    }

    public Tournament addPlayer(Long tournamentId, Long playerId) {
        Tournament t = getById(tournamentId);
        Player p = playerRepo.findById(playerId).orElseThrow();
        t.getPlayers().add(p);
        return tournamentRepo.save(t);
    }

    public Tournament removePlayer(Long tournamentId, Long playerId) {
        Tournament t = getById(tournamentId);
        Player p = playerRepo.findById(playerId).orElseThrow();
        t.getPlayers().remove(p);
        return tournamentRepo.save(t);
    }

    public void finish(Long tournamentId) {
        Tournament t = getById(tournamentId);
        t.setFinished(true);
        tournamentRepo.save(t);
    }

    public List<Player> listPlayers(Long tournamentId) {
        return List.copyOf(getById(tournamentId).getPlayers());
    }
}
