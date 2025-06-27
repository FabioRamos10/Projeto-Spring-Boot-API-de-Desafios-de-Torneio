package com.we.tournament.backend.repository;

import com.we.tournament.backend.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository repository;

    @Test
    public void testFindByNameContainingIgnoreCase() {
        Player player = new Player();
        player.setName("Carlos Silva");
        repository.save(player);

        List<Player> players = repository.findByNameContainingIgnoreCase("carlos");
        assertThat(players).isNotEmpty();
        assertThat(players.get(0).getName()).isEqualTo("Carlos Silva");
    }
}
