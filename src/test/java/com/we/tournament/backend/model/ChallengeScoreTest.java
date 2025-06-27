package com.we.tournament.backend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeScoreTest {

    @Test
    void testChallengeScoreBuilder() {
        Player player = Player.builder().id(1L).name("Ana").build();
        Tournament tournament = Tournament.builder().id(2L).name("Outono Cup").build();

        ChallengeScore cs = ChallengeScore.builder()
                .id(100L)
                .player(player)
                .tournament(tournament)
                .challengeType("Soma")
                .score(90)
                .build();

        assertEquals("Soma", cs.getChallengeType());
        assertEquals(90, cs.getScore());
        assertEquals(player, cs.getPlayer());
        assertEquals(tournament, cs.getTournament());
    }
}
