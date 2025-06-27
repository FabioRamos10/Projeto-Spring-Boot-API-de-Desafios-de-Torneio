package com.we.tournament.backend.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class TournamentDTO {
    private Long id;
    private String name;
    private LocalDate date;
    private boolean finished;
    private Set<Long> playerIds;
}
