package com.we.tournament.backend.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RankingTest {

    @Test
    void testGettersAndSetters() {
        Ranking r = new Ranking();
        r.setId("rank1");
        r.setCategoria("Feminino");
        r.setNivel(1);

        assertThat(r.getId()).isEqualTo("rank1");
        assertThat(r.getCategoria()).isEqualTo("Feminino");
        assertThat(r.getNivel()).isEqualTo(1);
    }

    @Test
    void testEqualsAndHashCode() {
        Ranking r1 = new Ranking("id1", "A", 1);
        Ranking r2 = new Ranking("id1", "A", 1);
        assertThat(r1).isEqualTo(r2);
        assertThat(r1.hashCode()).isEqualTo(r2.hashCode());
    }
}