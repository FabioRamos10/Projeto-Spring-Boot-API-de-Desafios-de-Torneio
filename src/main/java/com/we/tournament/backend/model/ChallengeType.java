package com.we.tournament.backend.model;

public enum ChallengeType {
    FIBONACCI,
    PALINDROME,
    SORTING;

    public static boolean isValid(String input) {
        try {
            ChallengeType.valueOf(input.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
