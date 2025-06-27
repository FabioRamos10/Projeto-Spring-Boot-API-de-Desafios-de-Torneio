package com.we.tournament.backend.exeception;

public class ChallengeAlreadyExistsException extends RuntimeException {
    public ChallengeAlreadyExistsException(String message) {
        super(message);
    }

    public ChallengeAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChallengeAlreadyExistsException() {
        super();
    }
}