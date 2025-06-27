package com.we.tournament.backend.repository;

import com.we.tournament.backend.model.Challenge;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ChallengeRepositoryTest {

    @Autowired
    private ChallengeRepository repository;

    @Test
    public void testSaveAndFindById() {
        Challenge challenge = new Challenge();
        challenge.setId("123");
        challenge.setTitulo("Desafio 1");
        challenge.setData(LocalDate.now());
        challenge.setJogadorDesafianteId("player1");
        challenge.setJogadorDesafiadoId("player2");
        challenge.setStatus("PENDENTE");

        repository.save(challenge);

        Optional<Challenge> found = repository.findById("123");
        assertThat(found).isPresent();
        assertThat(found.get().getTitulo()).isEqualTo("Desafio 1");
    }
}
