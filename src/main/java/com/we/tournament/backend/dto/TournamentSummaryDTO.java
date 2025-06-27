package com.we.tournament.backend.dto;

import java.time.LocalDate;

public class TournamentSummaryDTO {
    private Long id;
    private String name;
    private LocalDate date;
    private boolean finished;

    public TournamentSummaryDTO() {
    }

    public TournamentSummaryDTO(Long id, String name, LocalDate date, boolean finished) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.finished = finished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
