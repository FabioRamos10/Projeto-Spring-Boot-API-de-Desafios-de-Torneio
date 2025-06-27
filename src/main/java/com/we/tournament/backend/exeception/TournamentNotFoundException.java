package com.we.tournament.backend.exeception;


public class TournamentNotFoundException extends RuntimeException {
    public TournamentNotFoundException(String message) {
        super(message);
    }

    public TournamentNotFoundException() {
        super();
    }
}