package com.we.tournament.backend.repository;

import com.we.tournament.backend.model.Tournament;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TournamentRepositoryTest {

    @Autowired
    private TournamentRepository repository;

    @Test
    public void testSaveAndFindById() {
        Tournament tournament = new Tournament();
        tournament.setName("Torneio 1");
        tournament.setDate(LocalDate.now());
        tournament.setFinished(false);

        tournament = repository.save(tournament);

        Optional<Tournament> found = repository.findById(tournament.getId());
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Torneio 1");
    }
}
