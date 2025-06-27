package com.we.tournament.backend.repository;

import com.we.tournament.backend.model.ChallengeScore;
import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.model.Tournament;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ChallengeScoreRepositoryTest {

    @Autowired
    private ChallengeScoreRepository scoreRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void testFindByTournamentIdAndPlayerId() {
        // Declara final para usar dentro da lambda
        final Tournament tournament = new Tournament();
        tournament.setName("Torneio Teste");
        tournament.setDate(LocalDate.of(2025, 6, 14));
        tournament.setFinished(false);
        tournamentRepository.save(tournament);

        final Player player = new Player();
        player.setName("Jogador Teste");
        playerRepository.save(player);

        ChallengeScore score = new ChallengeScore();
        score.setTournament(tournament);
        score.setPlayer(player);
        score.setScore(150);
        scoreRepository.save(score);

        List<ChallengeScore> byTournament = scoreRepository.findByTournamentId(tournament.getId());
        List<ChallengeScore> byPlayer = scoreRepository.findByPlayerId(player.getId());

        assertThat(byTournament)
                .isNotEmpty()
                .allMatch(s -> s.getTournament().getId().equals(tournament.getId()));

        assertThat(byPlayer)
                .isNotEmpty()
                .allMatch(s -> s.getPlayer().getId().equals(player.getId()));
    }
}
